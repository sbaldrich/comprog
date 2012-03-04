import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DegreesToRadiansTest {

    protected DegreesToRadians solution;

    @Before
    public void setUp() {
        solution = new DegreesToRadians();
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
        int degrees = 0;
        int minutes = 0;
        int seconds = 0;

        double expected = 0.0;
        double actual = solution.convertToRadians(degrees, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int degrees = 180;
        int minutes = 0;
        int seconds = 0;

        double expected = 3.141592653589793;
        double actual = solution.convertToRadians(degrees, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int degrees = 359;
        int minutes = 59;
        int seconds = 59;

        double expected = 6.283180459042776;
        double actual = solution.convertToRadians(degrees, minutes, seconds);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int degrees = 23;
        int minutes = 30;
        int seconds = 5;

        double expected = 0.41017661490272295;
        double actual = solution.convertToRadians(degrees, minutes, seconds);

        assertEquals(expected, actual);
    }

}
