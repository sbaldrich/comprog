import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiagonalDisproportionTest {

    protected DiagonalDisproportion solution;

    @Before
    public void setUp() {
        solution = new DiagonalDisproportion();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] matrix = new String[]{"190", "828", "373"};

        int expected = 1;
        int actual = solution.getDisproportion(matrix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] matrix = new String[]{"9000", "0120", "0000", "9000"};

        int expected = -1;
        int actual = solution.getDisproportion(matrix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] matrix = new String[]{"6"};

        int expected = 0;
        int actual = solution.getDisproportion(matrix);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] matrix = new String[]{"7748297018", "8395414567", "7006199788", "5446757413", "2972498628", "0508396790", "9986085827", "2386063041", "5687189519", "7729785238"};

        int expected = -24;
        int actual = solution.getDisproportion(matrix);

        Assert.assertEquals(expected, actual);
    }

}
