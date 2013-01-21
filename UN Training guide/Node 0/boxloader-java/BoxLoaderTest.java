import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoxLoaderTest {

    protected BoxLoader solution;

    @Before
    public void setUp() {
        solution = new BoxLoader();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int boxX = 100;
        int boxY = 98;
        int boxZ = 81;
        int itemX = 3;
        int itemY = 5;
        int itemZ = 7;

        int expected = 7560;
        int actual = solution.mostItems(boxX, boxY, boxZ, itemX, itemY, itemZ);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int boxX = 10;
        int boxY = 10;
        int boxZ = 10;
        int itemX = 9;
        int itemY = 9;
        int itemZ = 11;

        int expected = 0;
        int actual = solution.mostItems(boxX, boxY, boxZ, itemX, itemY, itemZ);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int boxX = 201;
        int boxY = 101;
        int boxZ = 301;
        int itemX = 100;
        int itemY = 30;
        int itemZ = 20;

        int expected = 100;
        int actual = solution.mostItems(boxX, boxY, boxZ, itemX, itemY, itemZ);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int boxX = 913;
        int boxY = 687;
        int boxZ = 783;
        int itemX = 109;
        int itemY = 93;
        int itemZ = 53;

        int expected = 833;
        int actual = solution.mostItems(boxX, boxY, boxZ, itemX, itemY, itemZ);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int boxX = 6;
        int boxY = 5;
        int boxZ = 4;
        int itemX = 3;
        int itemY = 2;
        int itemZ = 1;

        int expected = 20;
        int actual = solution.mostItems(boxX, boxY, boxZ, itemX, itemY, itemZ);

        Assert.assertEquals(expected, actual);
    }

}
