import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

class WordBreak{

    static boolean wordBreakBruteForce(String input, Set<String> words){
        int n = input.length();
        if( n == 0 ){
            return true;
        }
        for(int i = 1; i <= n; i++){
            if(words.contains(input.substring(0, i)) && wordBreakBruteForce(input.substring(i), words)){
                return true;
            }
        }
        return false;
    }

    static boolean wordBreakDP(String input, Set<String> words){
        int n = input.length();
        boolean[] dp = new boolean[n + 1];

        // dp[i] is true if input[0..i] can be split into words from the dictionary

        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && words.contains(input.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
    
}

class WordBreakTests{
    @Disabled
    @ParameterizedTest(name = "Using brute force, word {0} can be broken into words {1} : {2}")
    @MethodSource("testData")
    void bruteForceMethodTests(String string, List<String> words, boolean expected){
        assertEquals(expected, WordBreak.wordBreakBruteForce(string, words));
    }
 
    @ParameterizedTest(name = "Using dynamic programming word {0} can be broken into words {1} : {2}")
    @MethodSource("testData")
    void DynamicProgrammingMethodTests(String string, List<String> words, boolean expected){
        assertEquals(expected, WordBreak.wordBreakDP(string, words));
    }


    static Stream<Arguments> testData(){
        return Stream.of(
            Arguments.of("thisstringcanbebroken", Set.of("this", "string", "yes", "can", "be", "broken"), true),
            Arguments.of("banana", Set.of("banana") , true)
        );
    }
}