import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExerciseMachineTest {

    protected ExerciseMachine solution;

    @Before
    public void setUp() {
        solution = new ExerciseMachine();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String time = "00:30:00";

        int expected = 99;
        int actual = solution.getPercentages(time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String time = "00:28:00";

        int expected = 19;
        int actual = solution.getPercentages(time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String time = "23:59:59";

        int expected = 0;
        int actual = solution.getPercentages(time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String time = "00:14:10";

        int expected = 49;
        int actual = solution.getPercentages(time);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String time = "00:19:16";

        int expected = 3;
        int actual = solution.getPercentages(time);

        Assert.assertEquals(expected, actual);
    }

}
