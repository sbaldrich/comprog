import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FortunateNumbersTest {

    protected FortunateNumbers solution;

    @Before
    public void setUp() {
        solution = new FortunateNumbers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] a = new int[]{1, 10, 100};
        int[] b = new int[]{3, 53};
        int[] c = new int[]{4, 54};

        int expected = 2;
        int actual = solution.getFortunate(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] a = new int[]{47};
        int[] b = new int[]{500};
        int[] c = new int[]{33};

        int expected = 0;
        int actual = solution.getFortunate(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] a = new int[]{100, 1, 10, 100, 1, 1};
        int[] b = new int[]{3, 53, 53, 53, 53, 53, 53};
        int[] c = new int[]{4, 54, 4, 54, 4, 54};

        int expected = 2;
        int actual = solution.getFortunate(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] a = new int[]{500, 800};
        int[] b = new int[]{50, 80};
        int[] c = new int[]{5, 8};

        int expected = 8;
        int actual = solution.getFortunate(a, b, c);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] a = new int[]{30000, 26264};
        int[] b = new int[]{30000, 29294};
        int[] c = new int[]{30000, 29594};

        int expected = 3;
        int actual = solution.getFortunate(a, b, c);

        Assert.assertEquals(expected, actual);
    }

}
