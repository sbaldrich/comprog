import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicalGirlLevelOneDivTwoTest {

    protected MagicalGirlLevelOneDivTwo solution;

    @Before
    public void setUp() {
        solution = new MagicalGirlLevelOneDivTwo();
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
        int d = 5;
        int x = 10;
        int y = 10;

        double expected = 7.0710678118654755;
        double actual = solution.theMinDistance(d, x, y);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int d = 5;
        int x = 10;
        int y = 3;

        double expected = 5.0;
        double actual = solution.theMinDistance(d, x, y);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int d = 5;
        int x = -8;
        int y = -6;

        double expected = 3.1622776601683795;
        double actual = solution.theMinDistance(d, x, y);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int d = 5;
        int x = 3;
        int y = 2;

        double expected = 0.0;
        double actual = solution.theMinDistance(d, x, y);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int d = 24;
        int x = 24;
        int y = -24;

        double expected = 0.0;
        double actual = solution.theMinDistance(d, x, y);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int d = 345;
        int x = -471;
        int y = 333;

        double expected = 126.0;
        double actual = solution.theMinDistance(d, x, y);

        assertEquals(expected, actual);
    }

}
