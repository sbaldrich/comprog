import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryPolynomialDivTwoTest {

    protected BinaryPolynomialDivTwo solution;

    @Before
    public void setUp() {
        solution = new BinaryPolynomialDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] a = new int[]{1, 0, 1};

        int expected = 1;
        int actual = solution.countRoots(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] a = new int[]{0, 1, 0, 1};

        int expected = 2;
        int actual = solution.countRoots(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] a = new int[]{1};

        int expected = 0;
        int actual = solution.countRoots(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] a = new int[]{1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1};

        int expected = 0;
        int actual = solution.countRoots(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] a = new int[]{1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1};

        int expected = 1;
        int actual = solution.countRoots(a);

        Assert.assertEquals(expected, actual);
    }

}
