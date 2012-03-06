import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicSquareTest {

    protected MagicSquare solution;

    @Before
    public void setUp() {
        solution = new MagicSquare();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] square = new int[]{8, 1, 6, 3, 5, -1, 4, 9, 2};

        int expected = 7;
        int actual = solution.missing(square);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] square = new int[]{-1, 1, 6, 3, 5, 7, 4, 9, 2};

        int expected = 8;
        int actual = solution.missing(square);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] square = new int[]{5, 15, 13, 19, 11, 3, 9, 7, -1};

        int expected = 17;
        int actual = solution.missing(square);

        Assert.assertEquals(expected, actual);
    }

}
