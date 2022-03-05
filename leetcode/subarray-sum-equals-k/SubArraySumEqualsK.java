import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.*;
import java.util.*;

class SubArraySumEqualsK{

    public static void main(String[] args){
        subArraySumEqualsK(new int[]{1,2,3}, 3);
    }

    static int subArraySumEqualsK(int[] ints, int k){
        long prefixSums[] = new long[ints.length + 1];
        int ans = 0;
        for(int i = 1; i <= ints.length; i++){
            prefixSums[i] = prefixSums[i - 1] + ints[i - 1];
        }
        Map<Long, Integer> memo = new HashMap<>();
        for(int i = 0; i < prefixSums.length; i++){
            ans += memo.getOrDefault(prefixSums[i], 0);
            memo.merge(prefixSums[i] + k, 1, Integer::sum);
        }
        return ans;
    }
}

class SubArraySumEqualsKTests{
    @ParameterizedTest(name = "f({0}, {1}) = {2}")
    @MethodSource("testData")
    void tests(int[] ints, int k, int expected){
        assertEquals(expected, SubArraySumEqualsK.subArraySumEqualsK(ints, k));
    }

    static Stream<Arguments> testData(){
        return Stream.of(
            Arguments.of(new int[]{1,1,1}, 2, 2),
            Arguments.of(new int[]{1,2,3}, 3, 2),
            Arguments.of(new int[]{1,2,1,2,1,4}, 4, 3)
        );
    }
}