import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TournamentJudgingTest {

    protected TournamentJudging solution;

    @Before
    public void setUp() {
        solution = new TournamentJudging();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] rawScores = new int[]{10, 20, 30};
        int[] conversionFactor = new int[]{10, 10, 5};

        int expected = 9;
        int actual = solution.getPoints(rawScores, conversionFactor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] rawScores = new int[]{8, 16, 32};
        int[] conversionFactor = new int[]{10, 10, 5};

        int expected = 9;
        int actual = solution.getPoints(rawScores, conversionFactor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] rawScores = new int[]{60, 59};
        int[] conversionFactor = new int[]{24, 24};

        int expected = 5;
        int actual = solution.getPoints(rawScores, conversionFactor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] rawScores = new int[]{47, 42, 37, 30, 27, 21, 18};
        int[] conversionFactor = new int[]{1, 2, 3, 4, 5, 6, 7};

        int expected = 100;
        int actual = solution.getPoints(rawScores, conversionFactor);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] rawScores = new int[]{0, 1000000, 5000, 1000000};
        int[] conversionFactor = new int[]{1, 2, 1000000, 4};

        int expected = 750000;
        int actual = solution.getPoints(rawScores, conversionFactor);

        Assert.assertEquals(expected, actual);
    }

}
