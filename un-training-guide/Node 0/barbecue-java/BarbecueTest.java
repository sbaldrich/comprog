import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BarbecueTest {

    protected Barbecue solution;

    @Before
    public void setUp() {
        solution = new Barbecue();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 3;
        int[] voter = new int[]{0, 1, 2, 2};
        int[] excluded = new int[]{2, 2, 0, 1};

        int expected = 2;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 3;
        int[] voter = new int[]{0, 2, 2};
        int[] excluded = new int[]{2, 0, 1};

        int expected = 2;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 2;
        int[] voter = new int[]{0, 1};
        int[] excluded = new int[]{1, 0};

        int expected = 0;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 20;
        int[] voter = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 19, 19, 19};
        int[] excluded = new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3};

        int expected = 2;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int n = 5;
        int[] voter = new int[]{4, 3, 1, 0};
        int[] excluded = new int[]{2, 2, 3, 3};

        int expected = 3;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int n = 10;
        int[] voter = new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2};
        int[] excluded = new int[]{5, 6, 7, 8, 9, 0, 1, 2, 3};

        int expected = 0;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        int n = 7;
        int[] voter = new int[]{1, 2, 3, 4, 5, 6, 0, 2, 3, 4, 5, 6, 0, 1, 3, 4, 5, 6, 0, 1, 2, 4, 5, 6, 0, 1, 2, 3, 5, 6, 0, 1, 2, 3, 4, 6, 0, 1, 2, 3, 4, 5};
        int[] excluded = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6};

        int expected = 0;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase7() {
        int n = 5;
        int[] voter = new int[]{};
        int[] excluded = new int[]{};

        int expected = 0;
        int actual = solution.eliminate(n, voter, excluded);

        Assert.assertEquals(expected, actual);
    }

}
