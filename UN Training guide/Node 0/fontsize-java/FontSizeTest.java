import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FontSizeTest {

    protected FontSize solution;

    @Before
    public void setUp() {
        solution = new FontSize();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String sentence = "Dead Beef";
        int[] uppercase = new int[]{6, 6, 6, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] lowercase = new int[]{5, 5, 5, 4, 4, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};

        int expected = 49;
        int actual = solution.getPixelWidth(sentence, uppercase, lowercase);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String sentence = "Hello World";
        int[] uppercase = new int[]{7, 8, 8, 8, 7, 8, 8, 8, 7, 8, 8, 8, 8, 8, 7, 8, 8, 8, 8, 8, 7, 8, 8, 8, 8, 8};
        int[] lowercase = new int[]{5, 6, 6, 6, 5, 6, 6, 6, 5, 6, 6, 6, 6, 6, 5, 6, 6, 6, 6, 6, 5, 6, 6, 6, 6, 6};

        int expected = 74;
        int actual = solution.getPixelWidth(sentence, uppercase, lowercase);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String sentence = "Hello World";
        int[] uppercase = new int[]{7, 7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 7, 7, 7};
        int[] lowercase = new int[]{5, 5, 5, 6, 6, 5, 5, 5, 5, 5, 5, 1, 5, 5, 6, 5, 5, 6, 5, 5, 5, 5, 5, 5, 5, 5};

        int expected = 63;
        int actual = solution.getPixelWidth(sentence, uppercase, lowercase);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String sentence = "ThE qUiCk BrOwN fOx JuMpEd OvEr ThE lAzY dOg";
        int[] uppercase = new int[]{36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        int[] lowercase = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

        int expected = 778;
        int actual = solution.getPixelWidth(sentence, uppercase, lowercase);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String sentence = "two  spaces";
        int[] uppercase = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] lowercase = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

        int expected = 43;
        int actual = solution.getPixelWidth(sentence, uppercase, lowercase);

        Assert.assertEquals(expected, actual);
    }

}
