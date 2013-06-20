import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnightCircuitTest {

    protected KnightCircuit solution;

    @Before
    public void setUp() {
        solution = new KnightCircuit();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int w = 1;
        int h = 1;
        int a = 2;
        int b = 1;

        long expected = 1L;
        long actual = solution.maxSize(w, h, a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int w = 3;
        int h = 20;
        int a = 1;
        int b = 3;

        long expected = 11L;
        long actual = solution.maxSize(w, h, a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int w = 100000;
        int h = 100000;
        int a = 1;
        int b = 2;

        long expected = 10000000000L;
        long actual = solution.maxSize(w, h, a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int w = 3;
        int h = 3;
        int a = 1;
        int b = 2;

        long expected = 8L;
        long actual = solution.maxSize(w, h, a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int w = 30;
        int h = 30;
        int a = 8;
        int b = 4;

        long expected = 64L;
        long actual = solution.maxSize(w, h, a, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int w = 32;
        int h = 34;
        int a = 6;
        int b = 2;

        long expected = 136L;
        long actual = solution.maxSize(w, h, a, b);

        Assert.assertEquals(expected, actual);
    }

}
