import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AverageCandyLifetimeTest {

    protected AverageCandyLifetime solution;

    @Before
    public void setUp() {
        solution = new AverageCandyLifetime();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] eatenCandies = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        double expected = 60.5;
        double actual = solution.getAverage(eatenCandies);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] eatenCandies = new int[]{0, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        double expected = 59.0;
        double actual = solution.getAverage(eatenCandies);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] eatenCandies = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 50, 0, 0};

        double expected = 301.5882352941176;
        double actual = solution.getAverage(eatenCandies);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] eatenCandies = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        double expected = 252.80769230769232;
        double actual = solution.getAverage(eatenCandies);

        assertEquals(expected, actual);
    }

}
