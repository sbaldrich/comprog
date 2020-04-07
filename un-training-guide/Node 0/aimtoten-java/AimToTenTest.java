import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AimToTenTest {

    protected AimToTen solution;

    @Before
    public void setUp() {
        solution = new AimToTen();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] marks = new int[]{9, 10, 10, 9};

        int expected = 0;
        int actual = solution.need(marks);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] marks = new int[]{8, 9};

        int expected = 4;
        int actual = solution.need(marks);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] marks = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int expected = 950;
        int actual = solution.need(marks);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] marks = new int[]{10, 10, 10, 10};

        int expected = 0;
        int actual = solution.need(marks);

        Assert.assertEquals(expected, actual);
    }

}
