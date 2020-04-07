import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpidersOnTheGridTest {

    protected SpidersOnTheGrid solution;

    @Before
    public void setUp() {
        solution = new SpidersOnTheGrid();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] A = new String[]{"EW", "NN"};

        int expected = 2;
        int actual = solution.find(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] A = new String[]{"EEEEEEEEEEEEEEEEEEEEEEEEEEEEEW"};

        int expected = 1;
        int actual = solution.find(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] A = new String[]{"EW"};

        int expected = 0;
        int actual = solution.find(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] A = new String[]{"ESW", "ENW"};

        int expected = 4;
        int actual = solution.find(A);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] A = new String[]{"E"};

        int expected = 1;
        int actual = solution.find(A);

        Assert.assertEquals(expected, actual);
    }

}
