import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OneDigitDifferenceTest {

    protected OneDigitDifference solution;

    @Before
    public void setUp() {
        solution = new OneDigitDifference();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 9;

        int expected = 0;
        int actual = solution.getSmallest(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 0;

        int expected = 1;
        int actual = solution.getSmallest(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 900000123;

        int expected = 123;
        int actual = solution.getSmallest(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 30000;

        int expected = 0;
        int actual = solution.getSmallest(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 47;

        int expected = 7;
        int actual = solution.getSmallest(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int N = 1907654321;

        int expected = 907654321;
        int actual = solution.getSmallest(N);

        Assert.assertEquals(expected, actual);
    }

}
