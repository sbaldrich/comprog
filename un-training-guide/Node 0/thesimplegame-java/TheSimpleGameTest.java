import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheSimpleGameTest {

    protected TheSimpleGame solution;

    @Before
    public void setUp() {
        solution = new TheSimpleGame();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 4;
        int[] x = new int[]{2};
        int[] y = new int[]{3};

        int expected = 2;
        int actual = solution.count(n, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 3;
        int[] x = new int[]{2, 2, 1, 3};
        int[] y = new int[]{2, 2, 3, 1};

        int expected = 4;
        int actual = solution.count(n, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 7;
        int[] x = new int[]{7, 1, 7, 7, 1, 7, 1};
        int[] y = new int[]{7, 1, 1, 1, 1, 7, 7};

        int expected = 0;
        int actual = solution.count(n, x, y);

        Assert.assertEquals(expected, actual);
    }

}
