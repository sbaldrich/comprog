import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FowlRoadTest {

    protected FowlRoad solution;

    @Before
    public void setUp() {
        solution = new FowlRoad();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int roadY = 6;
        int[] bobX = new int[]{3, 7, 9, 2};
        int[] bobY = new int[]{-3, 8, 8, 2};

        int expected = 2;
        int actual = solution.crossings(roadY, bobX, bobY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int roadY = 10;
        int[] bobX = new int[]{3, 7, 9, 2};
        int[] bobY = new int[]{-3, 8, 8, 2};

        int expected = 0;
        int actual = solution.crossings(roadY, bobX, bobY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int roadY = 0;
        int[] bobX = new int[]{3, 2, 5, 6, 9};
        int[] bobY = new int[]{2, 0, 0, 2, -88};

        int expected = 1;
        int actual = solution.crossings(roadY, bobX, bobY);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int roadY = 0;
        int[] bobX = new int[]{3, 2, 5, 6, 9};
        int[] bobY = new int[]{-2, 0, 0, 2, -88};

        int expected = 2;
        int actual = solution.crossings(roadY, bobX, bobY);

        Assert.assertEquals(expected, actual);
    }

}
