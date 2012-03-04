import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovingAveragesTest {

    protected MovingAverages solution;

    @Before
    public void setUp() {
        solution = new MovingAverages();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
        int n = 3;

        int[] expected = new int[]{4731, 4695, 4684};
        int[] actual = solution.calculate(times, n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
        int n = 1;

        int[] expected = new int[]{4750, 4660, 4784, 4643, 4627};
        int[] actual = solution.calculate(times, n);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
        int n = 5;

        int[] expected = new int[]{4692};
        int[] actual = solution.calculate(times, n);

        Assert.assertArrayEquals(expected, actual);
    }

}
