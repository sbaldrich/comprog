import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunnyPuzzleTest {

    protected BunnyPuzzle solution;

    @Before
    public void setUp() {
        solution = new BunnyPuzzle();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] bunnies = new int[]{5, 8};

        int expected = 2;
        int actual = solution.theCount(bunnies);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] bunnies = new int[]{-1, 0, 1};

        int expected = 2;
        int actual = solution.theCount(bunnies);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] bunnies = new int[]{0, 1, 3};

        int expected = 3;
        int actual = solution.theCount(bunnies);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] bunnies = new int[]{-677, -45, -2, 3, 8, 29, 384, 867};

        int expected = 7;
        int actual = solution.theCount(bunnies);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] bunnies = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int expected = 2;
        int actual = solution.theCount(bunnies);

        Assert.assertEquals(expected, actual);
    }

}
