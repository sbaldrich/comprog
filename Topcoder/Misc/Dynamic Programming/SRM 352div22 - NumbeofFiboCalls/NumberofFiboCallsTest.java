import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberofFiboCallsTest {

    protected NumberofFiboCalls solution;

    @Before
    public void setUp() {
        solution = new NumberofFiboCalls();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 0;

        int[] expected = new int[]{1, 0};
        int[] actual = solution.fiboCallsMade(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 3;

        int[] expected = new int[]{1, 2};
        int[] actual = solution.fiboCallsMade(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 6;

        int[] expected = new int[]{5, 8};
        int[] actual = solution.fiboCallsMade(n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 22;

        int[] expected = new int[]{10946, 17711};
        int[] actual = solution.fiboCallsMade(n);

        Assert.assertArrayEquals(expected, actual);
    }
}
