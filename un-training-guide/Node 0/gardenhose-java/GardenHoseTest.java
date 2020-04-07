import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GardenHoseTest {

    protected GardenHose solution;

    @Before
    public void setUp() {
        solution = new GardenHose();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 3;
        int rowDist = 2;
        int colDist = 1;
        int hoseDist = 2;

        int expected = 0;
        int actual = solution.countDead(n, rowDist, colDist, hoseDist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 3;
        int rowDist = 2;
        int colDist = 1;
        int hoseDist = 1;

        int expected = 3;
        int actual = solution.countDead(n, rowDist, colDist, hoseDist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 6;
        int rowDist = 2;
        int colDist = 5;
        int hoseDist = 5;

        int expected = 8;
        int actual = solution.countDead(n, rowDist, colDist, hoseDist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 6;
        int rowDist = 2;
        int colDist = 5;
        int hoseDist = 3;

        int expected = 24;
        int actual = solution.countDead(n, rowDist, colDist, hoseDist);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int n = 50;
        int rowDist = 50;
        int colDist = 50;
        int hoseDist = 49;

        int expected = 2500;
        int actual = solution.countDead(n, rowDist, colDist, hoseDist);

        Assert.assertEquals(expected, actual);
    }

}
