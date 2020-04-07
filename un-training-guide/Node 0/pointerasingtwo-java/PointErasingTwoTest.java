import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointErasingTwoTest {

    protected PointErasingTwo solution;

    @Before
    public void setUp() {
        solution = new PointErasingTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] y = new int[]{1, 2, 1, 1, 0, 4, 3};

        int expected = 2;
        int actual = solution.getMaximum(y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] y = new int[]{0, 1};

        int expected = 0;
        int actual = solution.getMaximum(y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] y = new int[]{0, 1, 2, 3, 4};

        int expected = 3;
        int actual = solution.getMaximum(y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] y = new int[]{10, 19, 10, 19};

        int expected = 0;
        int actual = solution.getMaximum(y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] y = new int[]{0, 23, 49, 50, 32, 0, 18, 50, 0, 28, 50, 27, 49, 0};

        int expected = 5;
        int actual = solution.getMaximum(y);

        Assert.assertEquals(expected, actual);
    }

}
