import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceApproximatorTest {

    protected RaceApproximator solution;

    @Before
    public void setUp() {
        solution = new RaceApproximator();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int d1 = 800;
        int t1 = 118;
        int d2 = 5000;
        int t2 = 906;
        int raceDistance = 1500;

        String expected = "0:03:57";
        String actual = solution.timeToBeat(d1, t1, d2, t2, raceDistance);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int d1 = 400;
        int t1 = 65;
        int d2 = 1600;
        int t2 = 350;
        int raceDistance = 800;

        String expected = "0:02:30";
        String actual = solution.timeToBeat(d1, t1, d2, t2, raceDistance);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int d1 = 1600;
        int t1 = 299;
        int d2 = 10000;
        int t2 = 2360;
        int raceDistance = 5000;

        String expected = "0:18:00";
        String actual = solution.timeToBeat(d1, t1, d2, t2, raceDistance);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int d1 = 100;
        int t1 = 17;
        int d2 = 10000;
        int t2 = 4500;
        int raceDistance = 9000;

        String expected = "1:06:00";
        String actual = solution.timeToBeat(d1, t1, d2, t2, raceDistance);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int d1 = 156;
        int t1 = 117;
        int d2 = 3863;
        int t2 = 2754;
        int raceDistance = 1755;

        String expected = "0:21:06";
        String actual = solution.timeToBeat(d1, t1, d2, t2, raceDistance);

        Assert.assertEquals(expected, actual);
    }

}
