import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InverseFactoringTest {

    protected InverseFactoring solution;

    @Before
    public void setUp() {
        solution = new InverseFactoring();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] factors = new int[]{2};

        int expected = 4;
        int actual = solution.getTheNumber(factors);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] factors = new int[]{4, 2};

        int expected = 8;
        int actual = solution.getTheNumber(factors);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] factors = new int[]{3, 4, 2, 12, 6, 8};

        int expected = 24;
        int actual = solution.getTheNumber(factors);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] factors = new int[]{14, 26456, 2, 28, 13228, 3307, 7, 23149, 8, 6614, 46298, 56, 4, 92596};

        int expected = 185192;
        int actual = solution.getTheNumber(factors);

        Assert.assertEquals(expected, actual);
    }

}
