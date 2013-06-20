import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuessingNextElementTest {

    protected GuessingNextElement solution;

    @Before
    public void setUp() {
        solution = new GuessingNextElement();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] A = new int[]{364, 843, 1322, 1801};

        int expected = 2280;
        int actual = solution.guess(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] A = new int[]{394, 1172, 1950, 2728, 3506, 4284, 5062, 5840};

        int expected = 6618;
        int actual = solution.guess(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] A = new int[]{13, 117, 1053, 9477, 85293};

        int expected = 767637;
        int actual = solution.guess(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] A = new int[]{22, 220, 2200, 22000};

        int expected = 220000;
        int actual = solution.guess(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] A = new int[]{250000, 500000, 1000000};

        int expected = 2000000;
        int actual = solution.guess(A);

        Assert.assertEquals(expected, actual);
    }

}
