import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangleTypeTest {

    protected TriangleType solution;

    @Before
    public void setUp() {
        solution = new TriangleType();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int a = 3;
        int b = 4;
        int c = 5;

        String expected = "RIGHT";
        String actual = solution.type(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int a = 3;
        int b = 4;
        int c = 4;

        String expected = "ACUTE";
        String actual = solution.type(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int a = 3;
        int b = 4;
        int c = 6;

        String expected = "OBTUSE";
        String actual = solution.type(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int a = 7;
        int b = 4;
        int c = 3;

        String expected = "IMPOSSIBLE";
        String actual = solution.type(a, b, c);

        Assert.assertEquals(expected, actual);
    }

}
