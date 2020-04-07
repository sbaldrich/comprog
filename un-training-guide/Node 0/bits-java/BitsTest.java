import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BitsTest {

    protected Bits solution;

    @Before
    public void setUp() {
        solution = new Bits();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 32;

        int expected = 6;
        int actual = solution.minBits(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 12;

        int expected = 4;
        int actual = solution.minBits(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 1;

        int expected = 1;
        int actual = solution.minBits(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 1500;

        int expected = 11;
        int actual = solution.minBits(n);

        Assert.assertEquals(expected, actual);
    }

}
