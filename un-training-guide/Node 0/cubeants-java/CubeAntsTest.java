import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CubeAntsTest {

    protected CubeAnts solution;

    @Before
    public void setUp() {
        solution = new CubeAnts();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] pos = new int[]{0, 1, 1};

        int expected = 1;
        int actual = solution.getMinimumSteps(pos);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] pos = new int[]{5, 4};

        int expected = 2;
        int actual = solution.getMinimumSteps(pos);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] pos = new int[]{0};

        int expected = 0;
        int actual = solution.getMinimumSteps(pos);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] pos = new int[]{6, 1, 6};

        int expected = 3;
        int actual = solution.getMinimumSteps(pos);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] pos = new int[]{7, 7, 3, 3, 7, 7, 3, 3};

        int expected = 2;
        int actual = solution.getMinimumSteps(pos);

        Assert.assertEquals(expected, actual);
    }

}
