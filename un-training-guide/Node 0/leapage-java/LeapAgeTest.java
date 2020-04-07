import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeapAgeTest {

    protected LeapAge solution;

    @Before
    public void setUp() {
        solution = new LeapAge();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int year = 2004;
        int born = 1980;

        int expected = 6;
        int actual = solution.getAge(year, born);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int year = 10000;
        int born = 1582;

        int expected = 2042;
        int actual = solution.getAge(year, born);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int year = 2007;
        int born = 1981;

        int expected = 6;
        int actual = solution.getAge(year, born);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int year = 1981;
        int born = 1980;

        int expected = 0;
        int actual = solution.getAge(year, born);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int year = 1984;
        int born = 1983;

        int expected = 1;
        int actual = solution.getAge(year, born);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int year = 9700;
        int born = 5795;

        int expected = 947;
        int actual = solution.getAge(year, born);

        Assert.assertEquals(expected, actual);
    }

}
