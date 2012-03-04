import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class grafixClickTest {

    protected grafixClick solution;

    @Before
    public void setUp() {
        solution = new grafixClick();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] mouseRows = new int[]{20, 39, 100};
        int[] mouseCols = new int[]{99, 50, 200};

        int[] expected = new int[]{0, 1};
        int[] actual = solution.checkSaveButton(mouseRows, mouseCols);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] mouseRows = new int[]{0, 100, 399};
        int[] mouseCols = new int[]{0, 200, 599};

        int[] expected = new int[]{};
        int[] actual = solution.checkSaveButton(mouseRows, mouseCols);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] mouseRows = new int[]{30};
        int[] mouseCols = new int[]{75};

        int[] expected = new int[]{0};
        int[] actual = solution.checkSaveButton(mouseRows, mouseCols);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] mouseRows = new int[]{10, 20, 30, 30, 30, 30, 34, 35, 345};
        int[] mouseCols = new int[]{10, 20, 30, 50, 60, 80, 34, 35, 345};

        int[] expected = new int[]{3, 4, 5};
        int[] actual = solution.checkSaveButton(mouseRows, mouseCols);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] mouseRows = new int[]{57, 28, 18, 25, 36, 12, 33, 44, 13, 32, 32, 51, 11, 27, 8, 51, 17, 34, 10, 16, 47, 57, 20, 57, 32, 14, 13, 37, 10, 16, 49, 37, 52, 8, 18, 44, 50, 43, 11, 1, 21, 22, 17, 35, 28, 53, 56, 16, 11, 44};
        int[] mouseCols = new int[]{146, 22, 41, 88, 123, 99, 43, 110, 25, 64, 141, 110, 70, 34, 99, 103, 60, 64, 142, 109, 133, 144, 72, 68, 25, 32, 21, 140, 30, 105, 32, 72, 114, 97, 35, 131, 103, 110, 133, 81, 125, 36, 76, 78, 77, 47, 50, 94, 22, 20};

        int[] expected = new int[]{3, 9, 17, 22, 31, 43, 44};
        int[] actual = solution.checkSaveButton(mouseRows, mouseCols);

        Assert.assertArrayEquals(expected, actual);
    }

}
