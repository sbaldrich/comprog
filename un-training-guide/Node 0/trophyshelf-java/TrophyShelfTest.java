import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrophyShelfTest {

    protected TrophyShelf solution;

    @Before
    public void setUp() {
        solution = new TrophyShelf();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] trophies = new int[]{1, 2, 3, 4, 5};

        int[] expected = new int[]{5, 1};
        int[] actual = solution.countVisible(trophies);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] trophies = new int[]{5, 5, 5, 5};

        int[] expected = new int[]{1, 1};
        int[] actual = solution.countVisible(trophies);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] trophies = new int[]{1, 2, 5, 2, 1};

        int[] expected = new int[]{3, 3};
        int[] actual = solution.countVisible(trophies);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] trophies = new int[]{1, 4, 2, 5, 3, 7, 1};

        int[] expected = new int[]{4, 2};
        int[] actual = solution.countVisible(trophies);

        Assert.assertArrayEquals(expected, actual);
    }

}
