import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivToZeroTest {

    protected DivToZero solution;

    @Before
    public void setUp() {
        solution = new DivToZero();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int num = 2000000000;
        int factor = 100;

        String expected = "00";
        String actual = solution.lastTwo(num, factor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int num = 1000;
        int factor = 3;

        String expected = "02";
        String actual = solution.lastTwo(num, factor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int num = 23442;
        int factor = 75;

        String expected = "00";
        String actual = solution.lastTwo(num, factor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int num = 428392;
        int factor = 17;

        String expected = "15";
        String actual = solution.lastTwo(num, factor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int num = 32442;
        int factor = 99;

        String expected = "72";
        String actual = solution.lastTwo(num, factor);

        Assert.assertEquals(expected, actual);
    }

}
