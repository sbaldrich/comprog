import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FallingFactorialPowerTest {

    protected FallingFactorialPower solution;

    @Before
    public void setUp() {
        solution = new FallingFactorialPower();
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
        int n = 7;
        int k = 3;

        double expected = 210.0;
        double actual = solution.compute(n, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 10;
        int k = 1;

        double expected = 10.0;
        double actual = solution.compute(n, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 5;
        int k = 0;

        double expected = 1.0;
        double actual = solution.compute(n, k);

        assertEquals(expected, actual);
    }
	
    @Test(timeout = 2000)
    public void testCase3() {
        int n = 3;
        int k = -1;

        double expected = 0.25;
        double actual = solution.compute(n, k);
        
        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int n = 2;
        int k = -3;

        double expected = 0.016666666666666666;
        double actual = solution.compute(n, k);

        assertEquals(expected, actual);
    }

}
