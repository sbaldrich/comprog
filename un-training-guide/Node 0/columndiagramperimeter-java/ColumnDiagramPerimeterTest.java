import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColumnDiagramPerimeterTest {

    protected ColumnDiagramPerimeter solution;

    @Before
    public void setUp() {
        solution = new ColumnDiagramPerimeter();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] a = new int[]{2, 3, 5, 6, 1};

        int expected = 22;
        int actual = solution.getPerimiter(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] a = new int[]{3, 2, 1};

        int expected = 12;
        int actual = solution.getPerimiter(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] a = new int[]{2, 2};

        int expected = 8;
        int actual = solution.getPerimiter(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] a = new int[]{1, 2, 1};

        int expected = 10;
        int actual = solution.getPerimiter(a);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] a = new int[]{1, 2, 3};

        int expected = 12;
        int actual = solution.getPerimiter(a);

        Assert.assertEquals(expected, actual);
    }

}
