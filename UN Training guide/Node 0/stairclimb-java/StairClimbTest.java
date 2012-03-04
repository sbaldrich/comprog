import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StairClimbTest {

    protected StairClimb solution;

    @Before
    public void setUp() {
        solution = new StairClimb();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] flights = new int[]{15};
        int stairsPerStride = 2;

        int expected = 8;
        int actual = solution.stridesTaken(flights, stairsPerStride);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] flights = new int[]{15, 15};
        int stairsPerStride = 2;

        int expected = 18;
        int actual = solution.stridesTaken(flights, stairsPerStride);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] flights = new int[]{5, 11, 9, 13, 8, 30, 14};
        int stairsPerStride = 3;

        int expected = 44;
        int actual = solution.stridesTaken(flights, stairsPerStride);

        Assert.assertEquals(expected, actual);
    }

}
