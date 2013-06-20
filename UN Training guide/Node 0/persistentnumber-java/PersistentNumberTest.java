import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersistentNumberTest {

    protected PersistentNumber solution;

    @Before
    public void setUp() {
        solution = new PersistentNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 99;

        int expected = 2;
        int actual = solution.getPersistence(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 268;

        int expected = 4;
        int actual = solution.getPersistence(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 6;

        int expected = 0;
        int actual = solution.getPersistence(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 68889789;

        int expected = 3;
        int actual = solution.getPersistence(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int n = 86898;

        int expected = 7;
        int actual = solution.getPersistence(n);

        Assert.assertEquals(expected, actual);
    }

}
