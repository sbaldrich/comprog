import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionCyclesTest {

    protected AdditionCycles solution;

    @Before
    public void setUp() {
        solution = new AdditionCycles();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 26;

        int expected = 4;
        int actual = solution.cycleLength(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 55;

        int expected = 3;
        int actual = solution.cycleLength(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 0;

        int expected = 1;
        int actual = solution.cycleLength(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 71;

        int expected = 12;
        int actual = solution.cycleLength(n);

        Assert.assertEquals(expected, actual);
    }

}
