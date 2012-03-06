import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReversedSumTest {

    protected ReversedSum solution;

    @Before
    public void setUp() {
        solution = new ReversedSum();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int x = 123;
        int y = 100;

        int expected = 223;
        int actual = solution.getReversedSum(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int x = 111;
        int y = 111;

        int expected = 222;
        int actual = solution.getReversedSum(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int x = 5;
        int y = 5;

        int expected = 1;
        int actual = solution.getReversedSum(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int x = 1000;
        int y = 1;

        int expected = 2;
        int actual = solution.getReversedSum(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int x = 456;
        int y = 789;

        int expected = 1461;
        int actual = solution.getReversedSum(x, y);

        Assert.assertEquals(expected, actual);
    }

}
