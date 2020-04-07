import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiReadTest {

    protected MultiRead solution;

    @Before
    public void setUp() {
        solution = new MultiRead();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String trace = "RWWRRR";
        int procs = 3;

        int expected = 4;
        int actual = solution.minCycles(trace, procs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String trace = "RWWRRRR";
        int procs = 3;

        int expected = 5;
        int actual = solution.minCycles(trace, procs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String trace = "WWWWW";
        int procs = 5;

        int expected = 5;
        int actual = solution.minCycles(trace, procs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String trace = "RRRRRRRRRR";
        int procs = 4;

        int expected = 3;
        int actual = solution.minCycles(trace, procs);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String trace = "RWRRWWRWRWRRRWWRRRRWRRWRRWRRRRRRRRRWRWRWRRRRWRRRRR";
        int procs = 4;

        int expected = 30;
        int actual = solution.minCycles(trace, procs);

        Assert.assertEquals(expected, actual);
    }

}
