import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemperatureScalesTest {

    protected TemperatureScales solution;

    @Before
    public void setUp() {
        solution = new TemperatureScales();
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
        int f1 = 0;
        int b1 = 100;
        int f2 = 0;
        int b2 = 100;
        int t = 28;

        double expected = 28.0;
        double actual = solution.convert(f1, b1, f2, b2, t);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int f1 = 0;
        int b1 = 100;
        int f2 = 1;
        int b2 = 101;
        int t = 28;

        double expected = 29.0;
        double actual = solution.convert(f1, b1, f2, b2, t);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int f1 = -1000;
        int b1 = -999;
        int f2 = -1000;
        int b2 = 1000;
        int t = 1000;

        double expected = 3999000.0;
        double actual = solution.convert(f1, b1, f2, b2, t);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int f1 = -10;
        int b1 = 0;
        int f2 = 1;
        int b2 = 2;
        int t = 17;

        double expected = 3.7;
        double actual = solution.convert(f1, b1, f2, b2, t);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int f1 = 17;
        int b1 = 98;
        int f2 = -123;
        int b2 = 12;
        int t = 22;

        double expected = -114.66666666666667;
        double actual = solution.convert(f1, b1, f2, b2, t);

        assertEquals(expected, actual);
    }

}
