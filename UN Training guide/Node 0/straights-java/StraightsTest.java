import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StraightsTest {

    protected Straights solution;

    @Before
    public void setUp() {
        solution = new Straights();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] hand = new int[]{0, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int k = 2;

        int expected = 5;
        int actual = solution.howMany(hand, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] hand = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 5;

        int expected = 9;
        int actual = solution.howMany(hand, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] hand = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int k = 13;

        int expected = 67108864;
        int actual = solution.howMany(hand, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] hand = new int[]{4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4};
        int k = 2;

        int expected = 0;
        int actual = solution.howMany(hand, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] hand = new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1};
        int k = 1;

        int expected = 31;
        int actual = solution.howMany(hand, k);

        Assert.assertEquals(expected, actual);
    }

}
