import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NoisySensorTest {

    protected NoisySensor solution;

    @Before
    public void setUp() {
        solution = new NoisySensor();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = solution.medianFilter(data);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] data = new int[]{10, 1, 9, 2, 8};

        int[] expected = new int[]{10, 9, 2, 8, 8};
        int[] actual = solution.medianFilter(data);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] data = new int[]{500, 500, 500, 500, 500};

        int[] expected = new int[]{500, 500, 500, 500, 500};
        int[] actual = solution.medianFilter(data);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] data = new int[]{-2147483648, 2147483647};

        int[] expected = new int[]{-2147483648, 2147483647};
        int[] actual = solution.medianFilter(data);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] data = new int[]{432296535, 1983848899, -434724194, 135703525, -1146336142, -680568092, -1183352724, 1337550909, -1597342716, -1901441857, 1726722019, -558651015, 649930787, 1889036519, 1752815826, 930647381, -852547667, 2028345278, -1835531493, -1040566300, -1566043783, -1282411107, -1123988603, 2132078516, -1169614369, -523503536, 1466102514, -2003903121, -779001645, 1919742042, 1210980485, -9273881, 1033032137, -1474003783, 296280591, 920184999, -1235054743, -1329769514, -1727085135};

        int[] expected = new int[]{432296535, 432296535, 135703525, -434724194, -680568092, -1146336142, -680568092, -1183352724, -1597342716, -1597342716, -558651015, 649930787, 649930787, 1752815826, 1752815826, 930647381, 930647381, -852547667, -1040566300, -1566043783, -1282411107, -1282411107, -1123988603, -1123988603, -523503536, -523503536, -523503536, -779001645, -779001645, 1210980485, 1210980485, 1033032137, -9273881, 296280591, 296280591, 296280591, -1235054743, -1329769514, -1727085135};
        int[] actual = solution.medianFilter(data);

        Assert.assertArrayEquals(expected, actual);
    }

}
