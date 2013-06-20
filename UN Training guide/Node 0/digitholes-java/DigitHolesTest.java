import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DigitHolesTest {

    protected DigitHoles solution;

    @Before
    public void setUp() {
        solution = new DigitHoles();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int number = 42;

        int expected = 1;
        int actual = solution.numHoles(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int number = 669;

        int expected = 3;
        int actual = solution.numHoles(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int number = 688;

        int expected = 5;
        int actual = solution.numHoles(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int number = 123;

        int expected = 0;
        int actual = solution.numHoles(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int number = 456;

        int expected = 2;
        int actual = solution.numHoles(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int number = 789;

        int expected = 3;
        int actual = solution.numHoles(number);

        Assert.assertEquals(expected, actual);
    }

}
