import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridGeneratorTest {

    protected GridGenerator solution;

    @Before
    public void setUp() {
        solution = new GridGenerator();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] row = new int[]{1, 0, 3, 4, 1};
        int[] col = new int[]{1, 4, 1, 0, 3};

        int expected = 579;
        int actual = solution.generate(row, col);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] row = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] col = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};

        int expected = 13163067;
        int actual = solution.generate(row, col);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] row = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] col = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        int expected = 0;
        int actual = solution.generate(row, col);

        Assert.assertEquals(expected, actual);
    }

}
