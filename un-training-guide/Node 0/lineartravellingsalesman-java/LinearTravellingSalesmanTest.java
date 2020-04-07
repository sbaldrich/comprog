import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinearTravellingSalesmanTest {

    protected LinearTravellingSalesman solution;

    @Before
    public void setUp() {
        solution = new LinearTravellingSalesman();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] x = new int[]{1, 3, 5};
        int[] y = new int[]{2, 2, 2};

        int expected = 4;
        int actual = solution.findMinimumDistance(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] x = new int[]{3, 2, 1};
        int[] y = new int[]{3, 2, 1};

        int expected = 4;
        int actual = solution.findMinimumDistance(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] x = new int[]{0, 100, 1000, 10000};
        int[] y = new int[]{0, 10, 100, 1000};

        int expected = 11000;
        int actual = solution.findMinimumDistance(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] x = new int[]{80, 60, 70, 50};
        int[] y = new int[]{50, 70, 60, 80};

        int expected = 60;
        int actual = solution.findMinimumDistance(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] x = new int[]{7, 7, 7, 7, 7, 7, 7};
        int[] y = new int[]{105, 1231, 5663, 295, 3062, 380, 7777};

        int expected = 7672;
        int actual = solution.findMinimumDistance(x, y);

        Assert.assertEquals(expected, actual);
    }

}
