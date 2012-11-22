import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColorCodeTest {

    protected ColorCode solution;

    @Before
    public void setUp() {
        solution = new ColorCode();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] code = new String[]{"yellow", "violet", "red"};

        long expected = 4700L;
        long actual = solution.getOhms(code);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] code = new String[]{"orange", "red", "blue"};

        long expected = 32000000L;
        long actual = solution.getOhms(code);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] code = new String[]{"white", "white", "white"};

        long expected = 99000000000L;
        long actual = solution.getOhms(code);

        Assert.assertEquals(expected, actual);
    }

}
