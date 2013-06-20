import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircularLineTest {

    protected CircularLine solution;

    @Before
    public void setUp() {
        solution = new CircularLine();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] t = new int[]{1, 1, 1, 1};

        int expected = 2;
        int actual = solution.longestTravel(t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] t = new int[]{1, 4, 4, 1, 5};

        int expected = 7;
        int actual = solution.longestTravel(t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] t = new int[]{1, 1, 1000};

        int expected = 2;
        int actual = solution.longestTravel(t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] t = new int[]{1, 1000, 1, 1000};

        int expected = 1001;
        int actual = solution.longestTravel(t);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] t = new int[]{1, 1, 1, 1, 4};

        int expected = 4;
        int actual = solution.longestTravel(t);

        Assert.assertEquals(expected, actual);
    }

}
