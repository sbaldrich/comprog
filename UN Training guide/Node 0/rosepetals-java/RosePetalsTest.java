import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RosePetalsTest {

    protected RosePetals solution;

    @Before
    public void setUp() {
        solution = new RosePetals();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] dice = new int[]{1, 2, 3, 2, 1};

        int expected = 2;
        int actual = solution.getScore(dice);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] dice = new int[]{4, 4, 5, 6, 5};

        int expected = 8;
        int actual = solution.getScore(dice);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] dice = new int[]{1, 2, 3, 3, 5};

        int expected = 8;
        int actual = solution.getScore(dice);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] dice = new int[]{3, 3, 3, 3, 3};

        int expected = 10;
        int actual = solution.getScore(dice);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] dice = new int[]{2, 2, 2, 2, 2};

        int expected = 0;
        int actual = solution.getScore(dice);

        Assert.assertEquals(expected, actual);
    }

}
