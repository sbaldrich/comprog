import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VacationTimeTest {

    protected VacationTime solution;

    @Before
    public void setUp() {
        solution = new VacationTime();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 3;
        int K = 3;
        int[] workingDays = new int[]{2};

        int expected = 1;
        int actual = solution.bestSchedule(N, K, workingDays);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 4;
        int K = 3;
        int[] workingDays = new int[]{3, 1, 2};

        int expected = 2;
        int actual = solution.bestSchedule(N, K, workingDays);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 5;
        int K = 3;
        int[] workingDays = new int[]{4, 1};

        int expected = 1;
        int actual = solution.bestSchedule(N, K, workingDays);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 9;
        int K = 2;
        int[] workingDays = new int[]{7, 4, 5, 6, 2};

        int expected = 0;
        int actual = solution.bestSchedule(N, K, workingDays);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 1000;
        int K = 513;
        int[] workingDays = new int[]{808, 459, 792, 863, 715, 70, 336, 731};

        int expected = 2;
        int actual = solution.bestSchedule(N, K, workingDays);

        Assert.assertEquals(expected, actual);
    }

}
