import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrankTest {

    protected Prank solution;

    @Before
    public void setUp() {
        solution = new Prank();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int apparentGain = 233;

        int[] expected = new int[]{117};
        int[] actual = solution.realWeight(apparentGain);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int apparentGain = 15;

        int[] expected = new int[]{4, 8};
        int[] actual = solution.realWeight(apparentGain);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int apparentGain = 1440;

        int[] expected = new int[]{38, 39, 42, 46, 49, 53, 66, 77, 94, 123, 182, 361};
        int[] actual = solution.realWeight(apparentGain);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int apparentGain = 100000;

        int[] expected = new int[]{325, 350, 550, 665, 1025, 1270, 2510, 3133, 5005, 6254, 12502, 25001};
        int[] actual = solution.realWeight(apparentGain);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int apparentGain = 93301;

        int[] expected = new int[]{3595, 46651};
        int[] actual = solution.realWeight(apparentGain);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int apparentGain = 16;

        int[] expected = new int[]{5};
        int[] actual = solution.realWeight(apparentGain);

        Assert.assertArrayEquals(expected, actual);
    }

}
