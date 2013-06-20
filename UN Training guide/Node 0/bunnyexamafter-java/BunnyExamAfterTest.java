import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunnyExamAfterTest {

    protected BunnyExamAfter solution;

    @Before
    public void setUp() {
        solution = new BunnyExamAfter();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String black = "ABC";
        String gray = "ABC";
        String white = "ABC";

        int expected = 0;
        int actual = solution.getMaximum(black, gray, white);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String black = "A";
        String gray = "B";
        String white = "B";

        int expected = 2;
        int actual = solution.getMaximum(black, gray, white);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String black = "ABC";
        String gray = "PQR";
        String white = "XYZ";

        int expected = 3;
        int actual = solution.getMaximum(black, gray, white);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String black = "AAAAA";
        String gray = "AABBB";
        String white = "BBBAA";

        int expected = 6;
        int actual = solution.getMaximum(black, gray, white);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String black = "TOPCODER";
        String gray = "TOPBUNNY";
        String white = "THEHONEY";

        int expected = 9;
        int actual = solution.getMaximum(black, gray, white);

        Assert.assertEquals(expected, actual);
    }

}
