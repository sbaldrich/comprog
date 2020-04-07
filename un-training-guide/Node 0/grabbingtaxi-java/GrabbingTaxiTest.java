import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GrabbingTaxiTest {

    protected GrabbingTaxi solution;

    @Before
    public void setUp() {
        solution = new GrabbingTaxi();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] tXs = new int[]{};
        int[] tYs = new int[]{};
        int gX = 3;
        int gY = 2;
        int walkTime = 10;
        int taxiTime = 2;

        int expected = 50;
        int actual = solution.minTime(tXs, tYs, gX, gY, walkTime, taxiTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] tXs = new int[]{-2, -2};
        int[] tYs = new int[]{0, -2};
        int gX = -4;
        int gY = -2;
        int walkTime = 15;
        int taxiTime = 3;

        int expected = 42;
        int actual = solution.minTime(tXs, tYs, gX, gY, walkTime, taxiTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] tXs = new int[]{3};
        int[] tYs = new int[]{0};
        int gX = 5;
        int gY = 0;
        int walkTime = 10;
        int taxiTime = 20;

        int expected = 50;
        int actual = solution.minTime(tXs, tYs, gX, gY, walkTime, taxiTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] tXs = new int[]{34, -12, 1, 0, 21, -43, -98, 11, 86, -31};
        int[] tYs = new int[]{11, 5, -68, 69, -78, -49, -36, -2, 1, 70};
        int gX = -97;
        int gY = -39;
        int walkTime = 47;
        int taxiTime = 13;

        int expected = 2476;
        int actual = solution.minTime(tXs, tYs, gX, gY, walkTime, taxiTime);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] tXs = new int[]{82, -60, 57, 98, 30, -67, 84, -42, -100, 62};
        int[] tYs = new int[]{-7, 90, 53, -56, -15, -87, 22, -3, -61, -30};
        int gX = 21;
        int gY = 15;
        int walkTime = 53;
        int taxiTime = 2;

        int expected = 1908;
        int actual = solution.minTime(tXs, tYs, gX, gY, walkTime, taxiTime);

        Assert.assertEquals(expected, actual);
    }

}
