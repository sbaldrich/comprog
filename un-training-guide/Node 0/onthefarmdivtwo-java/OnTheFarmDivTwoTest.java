import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OnTheFarmDivTwoTest {

    protected OnTheFarmDivTwo solution;

    @Before
    public void setUp() {
        solution = new OnTheFarmDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int heads = 3;
        int legs = 8;

        int[] expected = new int[]{2, 1};
        int[] actual = solution.animals(heads, legs);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int heads = 10;
        int legs = 40;

        int[] expected = new int[]{0, 10};
        int[] actual = solution.animals(heads, legs);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int heads = 10;
        int legs = 42;

        int[] expected = new int[]{};
        int[] actual = solution.animals(heads, legs);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int heads = 1;
        int legs = 3;

        int[] expected = new int[]{};
        int[] actual = solution.animals(heads, legs);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int heads = 0;
        int legs = 0;

        int[] expected = new int[]{0, 0};
        int[] actual = solution.animals(heads, legs);

        Assert.assertArrayEquals(expected, actual);
    }

}
