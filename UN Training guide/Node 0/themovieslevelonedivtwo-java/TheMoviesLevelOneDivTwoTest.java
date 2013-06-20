import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheMoviesLevelOneDivTwoTest {

    protected TheMoviesLevelOneDivTwo solution;

    @Before
    public void setUp() {
        solution = new TheMoviesLevelOneDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 2;
        int m = 3;
        int[] row = new int[]{1, 2};
        int[] seat = new int[]{2, 3};

        int expected = 1;
        int actual = solution.find(n, m, row, seat);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 2;
        int m = 3;
        int[] row = new int[]{1, 1, 1, 2, 2, 2};
        int[] seat = new int[]{1, 2, 3, 1, 2, 3};

        int expected = 0;
        int actual = solution.find(n, m, row, seat);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 4;
        int m = 7;
        int[] row = new int[]{1};
        int[] seat = new int[]{1};

        int expected = 23;
        int actual = solution.find(n, m, row, seat);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 10;
        int m = 8;
        int[] row = new int[]{1, 9, 6, 10, 6, 7, 9, 3, 9, 2};
        int[] seat = new int[]{7, 7, 3, 3, 7, 1, 5, 1, 6, 2};

        int expected = 54;
        int actual = solution.find(n, m, row, seat);

        Assert.assertEquals(expected, actual);
    }

}
