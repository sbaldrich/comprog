import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HappyCellsTest {

    protected HappyCells solution;

    @Before
    public void setUp() {
        solution = new HappyCells();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] grid = new String[]{"XXX", "X.X", "XXX"};

        int[] expected = new int[]{1, 0, 0};
        int[] actual = solution.getHappy(grid);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] grid = new String[]{"."};

        int[] expected = new int[]{1, 0, 0};
        int[] actual = solution.getHappy(grid);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] grid = new String[]{"XXXXXX", "X.XXXX", "XXX.XX", "X..XXX", "XXXXXX"};

        int[] expected = new int[]{1, 1, 1};
        int[] actual = solution.getHappy(grid);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] grid = new String[]{"..."};

        int[] expected = new int[]{0, 0, 3};
        int[] actual = solution.getHappy(grid);

        Assert.assertArrayEquals(expected, actual);
    }

}
