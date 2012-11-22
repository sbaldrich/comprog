import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MedianOfNumbersTest {

    protected MedianOfNumbers solution;

    @Before
    public void setUp() {
        solution = new MedianOfNumbers();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] numbers = new int[]{1, 4, 2, 5, 7};

        int expected = 4;
        int actual = solution.findMedian(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] numbers = new int[]{1, 5, 8, 3};

        int expected = -1;
        int actual = solution.findMedian(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] numbers = new int[]{7};

        int expected = 7;
        int actual = solution.findMedian(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] numbers = new int[]{7, 12};

        int expected = -1;
        int actual = solution.findMedian(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] numbers = new int[]{66, 53, 47, 86, 18, 21, 97, 92, 15};

        int expected = 53;
        int actual = solution.findMedian(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] numbers = new int[]{32, 54, 27, 4, 69, 96, 73, 1, 100, 15, 21};

        int expected = 32;
        int actual = solution.findMedian(numbers);

        Assert.assertEquals(expected, actual);
    }

}
