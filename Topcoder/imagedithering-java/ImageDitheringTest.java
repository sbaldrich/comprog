import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImageDitheringTest {

    protected ImageDithering solution;

    @Before
    public void setUp() {
        solution = new ImageDithering();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String dithered = "BW";
        String[] screen = new String[]{"AAAAAAAA", "ABWBWBWA", "AWBWBWBA", "ABWBWBWA", "AWBWBWBA", "AAAAAAAA"};

        int expected = 24;
        int actual = solution.count(dithered, screen);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String dithered = "BW";
        String[] screen = new String[]{"BBBBBBBB", "BBWBWBWB", "BWBWBWBB", "BBWBWBWB", "BWBWBWBB", "BBBBBBBB"};

        int expected = 48;
        int actual = solution.count(dithered, screen);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String dithered = "ACEGIKMOQSUWY";
        String[] screen = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"};

        int expected = 150;
        int actual = solution.count(dithered, screen);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String dithered = "CA";
        String[] screen = new String[]{"BBBBBBB", "BBBBBBB", "BBBBBBB"};

        int expected = 0;
        int actual = solution.count(dithered, screen);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String dithered = "DCBA";
        String[] screen = new String[]{"ACBD"};

        int expected = 4;
        int actual = solution.count(dithered, screen);

        Assert.assertEquals(expected, actual);
    }

}
