import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValueAddedTaxTest {

    protected ValueAddedTax solution;

    @Before
    public void setUp() {
        solution = new ValueAddedTax();
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
        String product = "milk";
        int price = 1;
        String[] food = new String[]{"bread", "butter", "milk"};

        double expected = 1.1;
        double actual = solution.calculateFinalPrice(product, price, food);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String product = "car";
        int price = 100;
        String[] food = new String[]{"bread", "butter", "milk"};

        double expected = 118.0;
        double actual = solution.calculateFinalPrice(product, price, food);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String product = "abc";
        int price = 57;
        String[] food = new String[]{"a", "b", "c"};

        double expected = 67.25999999999999;
        double actual = solution.calculateFinalPrice(product, price, food);

        assertEquals(expected, actual);
    }

}
