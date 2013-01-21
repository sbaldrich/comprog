import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClockWalkTest {

    protected ClockWalk solution;

    @Before
    public void setUp() {
        solution = new ClockWalk();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String flips = "hhthh";

        int expected = 9;
        int actual = solution.finalPosition(flips);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String flips = "hhtht";

        int expected = 11;
        int actual = solution.finalPosition(flips);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String flips = "hthth";

        int expected = 3;
        int actual = solution.finalPosition(flips);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String flips = "hthhhhh";

        int expected = 12;
        int actual = solution.finalPosition(flips);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String flips = "hthhthtththhtttthttthhhthtttthh";

        int expected = 6;
        int actual = solution.finalPosition(flips);

        Assert.assertEquals(expected, actual);
    }

}
