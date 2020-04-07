import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoccerTest {

    protected Soccer solution;

    @Before
    public void setUp() {
        solution = new Soccer();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] wins = new int[]{1, 4, 3, 0, 0};
        int[] ties = new int[]{3, 1, 5, 3, 1};

        int expected = 14;
        int actual = solution.maxPoints(wins, ties);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] wins = new int[]{12, 45, 20, 17, 48, 0};
        int[] ties = new int[]{48, 10, 53, 94, 0, 100};

        int expected = 145;
        int actual = solution.maxPoints(wins, ties);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] wins = new int[]{35, 0};
        int[] ties = new int[]{0, 76};

        int expected = 105;
        int actual = solution.maxPoints(wins, ties);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] wins = new int[]{0, 0, 0, 0};
        int[] ties = new int[]{0, 0, 0, 0};

        int expected = 0;
        int actual = solution.maxPoints(wins, ties);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] wins = new int[]{13, 79, 26, 73, 14, 89, 71, 37, 89, 71, 19, 59, 39};
        int[] ties = new int[]{88, 27, 5, 70, 84, 94, 20, 50, 2, 11, 31, 22, 50};

        int expected = 361;
        int actual = solution.maxPoints(wins, ties);

        Assert.assertEquals(expected, actual);
    }

}
