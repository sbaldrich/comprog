import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuckyTicketSubstringTest {

    protected LuckyTicketSubstring solution;

    @Before
    public void setUp() {
        solution = new LuckyTicketSubstring();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String s = "123231";

        int expected = 6;
        int actual = solution.maxLength(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String s = "74233285";

        int expected = 4;
        int actual = solution.maxLength(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String s = "986561517416921217551395112859219257312";

        int expected = 36;
        int actual = solution.maxLength(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String s = "1";

        int expected = 0;
        int actual = solution.maxLength(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String s = "112";

        int expected = 2;
        int actual = solution.maxLength(s);

        Assert.assertEquals(expected, actual);
    }

}
