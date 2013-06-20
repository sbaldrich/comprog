import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComboLengthTest {

    protected ComboLength solution;

    @Before
    public void setUp() {
        solution = new ComboLength();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String moves = "AAA";

        int expected = 3;
        int actual = solution.howLong(moves);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String moves = "AAABBBBAA";

        int expected = 4;
        int actual = solution.howLong(moves);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String moves = "BBAABBAABBAABBAA";

        int expected = 2;
        int actual = solution.howLong(moves);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String moves = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

        int expected = 50;
        int actual = solution.howLong(moves);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String moves = "AAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAA";

        int expected = 25;
        int actual = solution.howLong(moves);

        Assert.assertEquals(expected, actual);
    }

}
