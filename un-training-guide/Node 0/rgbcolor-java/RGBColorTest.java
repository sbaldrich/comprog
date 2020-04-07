import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RGBColorTest {

    protected RGBColor solution;

    @Before
    public void setUp() {
        solution = new RGBColor();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] rgb = new int[]{255, 0, 0};

        int[] expected = new int[]{0, 255, 255};
        int[] actual = solution.getComplement(rgb);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] rgb = new int[]{115, 115, 143};

        int[] expected = new int[]{243, 243, 15};
        int[] actual = solution.getComplement(rgb);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] rgb = new int[]{115, 115, 144};

        int[] expected = new int[]{140, 140, 111};
        int[] actual = solution.getComplement(rgb);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] rgb = new int[]{153, 12, 55};

        int[] expected = new int[]{102, 243, 200};
        int[] actual = solution.getComplement(rgb);

        Assert.assertArrayEquals(expected, actual);
    }

}
