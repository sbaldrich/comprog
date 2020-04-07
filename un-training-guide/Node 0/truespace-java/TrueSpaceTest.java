import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrueSpaceTest {

    protected TrueSpace solution;

    @Before
    public void setUp() {
        solution = new TrueSpace();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] sizes = new int[]{600};
        int clusterSize = 512;

        long expected = 1024L;
        long actual = solution.calculateSpace(sizes, clusterSize);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] sizes = new int[]{16, 32, 128, 128, 0};
        int clusterSize = 32768;

        long expected = 131072L;
        long actual = solution.calculateSpace(sizes, clusterSize);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] sizes = new int[]{4096, 33792, 76800};
        int clusterSize = 1024;

        long expected = 114688L;
        long actual = solution.calculateSpace(sizes, clusterSize);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] sizes = new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000};
        int clusterSize = 1048576;

        long expected = 50017075200L;
        long actual = solution.calculateSpace(sizes, clusterSize);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] sizes = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int clusterSize = 8;

        long expected = 0L;
        long actual = solution.calculateSpace(sizes, clusterSize);

        Assert.assertEquals(expected, actual);
    }

}
