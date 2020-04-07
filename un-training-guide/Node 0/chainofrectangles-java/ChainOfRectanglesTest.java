import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChainOfRectanglesTest {

    protected ChainOfRectangles solution;

    @Before
    public void setUp() {
        solution = new ChainOfRectangles();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] width = new int[]{10000};
        int[] height = new int[]{10000};
        String color = "R";

        int expected = 100000000;
        int actual = solution.getMaximalArea(width, height, color);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] width = new int[]{10, 5};
        int[] height = new int[]{10, 5};
        String color = "GB";

        int expected = 75;
        int actual = solution.getMaximalArea(width, height, color);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] width = new int[]{10, 9};
        int[] height = new int[]{8, 7};
        String color = "GB";

        int expected = 63;
        int actual = solution.getMaximalArea(width, height, color);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] width = new int[]{10, 8, 6, 4, 2};
        int[] height = new int[]{9, 7, 5, 3, 1};
        String color = "GBRRG";

        int expected = 36;
        int actual = solution.getMaximalArea(width, height, color);

        Assert.assertEquals(expected, actual);
    }

}
