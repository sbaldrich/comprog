import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Subway2Test {

    protected Subway2 solution;

    @Before
    public void setUp() {
        solution = new Subway2();
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
        int length = 1;
        int maxAcceleration = 2;
        int maxVelocity = 10;

        double expected = 1.4142135623730951;
        double actual = solution.minTime(length, maxAcceleration, maxVelocity);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int length = 1;
        int maxAcceleration = 1;
        int maxVelocity = 1;

        double expected = 2.0;
        double actual = solution.minTime(length, maxAcceleration, maxVelocity);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int length = 10;
        int maxAcceleration = 1;
        int maxVelocity = 1;

        double expected = 11.0;
        double actual = solution.minTime(length, maxAcceleration, maxVelocity);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int length = 1;
        int maxAcceleration = 10;
        int maxVelocity = 1;

        double expected = 1.1;
        double actual = solution.minTime(length, maxAcceleration, maxVelocity);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int length = 778;
        int maxAcceleration = 887;
        int maxVelocity = 384;

        double expected = 2.458961621570838;
        double actual = solution.minTime(length, maxAcceleration, maxVelocity);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int length = 336;
        int maxAcceleration = 794;
        int maxVelocity = 916;

        double expected = 1.301036207838119;
        double actual = solution.minTime(length, maxAcceleration, maxVelocity);

        assertEquals(expected, actual);
    }

}
