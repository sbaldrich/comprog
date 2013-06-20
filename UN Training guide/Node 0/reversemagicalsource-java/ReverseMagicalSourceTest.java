import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseMagicalSourceTest {

    protected ReverseMagicalSource solution;

    @Before
    public void setUp() {
        solution = new ReverseMagicalSource();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int source = 19;
        int A = 200;

        int expected = 209;
        int actual = solution.find(source, A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int source = 19;
        int A = 18;

        int expected = 19;
        int actual = solution.find(source, A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int source = 333;
        int A = 36963;

        int expected = 369963;
        int actual = solution.find(source, A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int source = 1234;
        int A = 1000000;

        int expected = 1370974;
        int actual = solution.find(source, A);

        Assert.assertEquals(expected, actual);
    }

}
