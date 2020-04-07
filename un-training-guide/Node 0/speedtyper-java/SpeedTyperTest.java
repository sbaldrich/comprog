import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeedTyperTest {

    protected SpeedTyper solution;

    @Before
    public void setUp() {
        solution = new SpeedTyper();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String letters = "dcab";
        int[] times = new int[]{250, 300, 400, 800};

        String expected = "db";
        String actual = solution.lettersToPractice(letters, times);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String letters = "keyboard";
        int[] times = new int[]{100, 200, 300, 500, 600, 800, 900, 1200};

        String expected = "bad";
        String actual = solution.lettersToPractice(letters, times);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String letters = "rewq";
        int[] times = new int[]{500, 1000, 1500, 4000};

        String expected = "q";
        String actual = solution.lettersToPractice(letters, times);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String letters = "abc";
        int[] times = new int[]{2000, 4000, 6000};

        String expected = "";
        String actual = solution.lettersToPractice(letters, times);

        Assert.assertEquals(expected, actual);
    }

}
