import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LevelUpTest {

    protected LevelUp solution;

    @Before
    public void setUp() {
        solution = new LevelUp();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] expNeeded = new int[]{150, 450, 900, 1800};
        int received = 133;

        int expected = 17;
        int actual = solution.toNextLevel(expNeeded, received);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] expNeeded = new int[]{150, 450, 900, 1800};
        int received = 312;

        int expected = 138;
        int actual = solution.toNextLevel(expNeeded, received);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] expNeeded = new int[]{150, 450, 900, 1800};
        int received = 612;

        int expected = 288;
        int actual = solution.toNextLevel(expNeeded, received);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] expNeeded = new int[]{150, 450, 900, 1800};
        int received = 450;

        int expected = 450;
        int actual = solution.toNextLevel(expNeeded, received);

        Assert.assertEquals(expected, actual);
    }

}
