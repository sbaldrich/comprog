import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlternateColorsTest {

    protected AlternateColors solution;

    @Before
    public void setUp() {
        solution = new AlternateColors();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long r = 1L;
        long g = 1L;
        long b = 1L;
        long k = 3L;

        String expected = "BLUE";
        String actual = solution.getColor(r, g, b, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long r = 3L;
        long g = 4L;
        long b = 5L;
        long k = 4L;

        String expected = "RED";
        String actual = solution.getColor(r, g, b, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        long r = 7L;
        long g = 7L;
        long b = 1L;
        long k = 7L;

        String expected = "GREEN";
        String actual = solution.getColor(r, g, b, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        long r = 1000000000000L;
        long g = 1L;
        long b = 1L;
        long k = 1000000000002L;

        String expected = "RED";
        String actual = solution.getColor(r, g, b, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        long r = 653L;
        long g = 32L;
        long b = 1230L;
        long k = 556L;

        String expected = "BLUE";
        String actual = solution.getColor(r, g, b, k);

        Assert.assertEquals(expected, actual);
    }

}
