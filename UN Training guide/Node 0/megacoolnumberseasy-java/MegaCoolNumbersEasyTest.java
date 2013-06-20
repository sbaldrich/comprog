import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MegaCoolNumbersEasyTest {

    protected MegaCoolNumbersEasy solution;

    @Before
    public void setUp() {
        solution = new MegaCoolNumbersEasy();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 1;

        int expected = 1;
        int actual = solution.count(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 110;

        int expected = 99;
        int actual = solution.count(N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 500;

        int expected = 119;
        int actual = solution.count(N);

        Assert.assertEquals(expected, actual);
    }

}
