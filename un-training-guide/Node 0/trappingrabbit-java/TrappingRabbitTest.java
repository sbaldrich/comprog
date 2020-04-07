import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRabbitTest {

    protected TrappingRabbit solution;

    @Before
    public void setUp() {
        solution = new TrappingRabbit();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] trapX = new int[]{4, 6, 8};
        int[] trapY = new int[]{1, 2, 1};

        int expected = 3;
        int actual = solution.findMinimumTime(trapX, trapY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] trapX = new int[]{5, 4, 3};
        int[] trapY = new int[]{5, 4, 3};

        int expected = 4;
        int actual = solution.findMinimumTime(trapX, trapY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] trapX = new int[]{3, 4, 5};
        int[] trapY = new int[]{5, 4, 3};

        int expected = 6;
        int actual = solution.findMinimumTime(trapX, trapY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] trapX = new int[]{958, 375, 195, 686, 483, 629, 377};
        int[] trapY = new int[]{104, 505, 882, 357, 759, 400, 869};

        int expected = 878;
        int actual = solution.findMinimumTime(trapX, trapY);

        Assert.assertEquals(expected, actual);
    }

}
