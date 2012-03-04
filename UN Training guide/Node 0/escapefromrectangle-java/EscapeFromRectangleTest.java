import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EscapeFromRectangleTest {

    protected EscapeFromRectangle solution;

    @Before
    public void setUp() {
        solution = new EscapeFromRectangle();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int x = 1;
        int y = 1;
        int w = 5;
        int h = 5;

        int expected = 1;
        int actual = solution.shortest(x, y, w, h);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int x = 6;
        int y = 2;
        int w = 10;
        int h = 3;

        int expected = 1;
        int actual = solution.shortest(x, y, w, h);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int x = 653;
        int y = 375;
        int w = 1000;
        int h = 1000;

        int expected = 347;
        int actual = solution.shortest(x, y, w, h);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int x = 161;
        int y = 181;
        int w = 762;
        int h = 375;

        int expected = 161;
        int actual = solution.shortest(x, y, w, h);

        Assert.assertEquals(expected, actual);
    }

}
