import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AttendanceShortTest {

    protected AttendanceShort solution;

    @Before
    public void setUp() {
        solution = new AttendanceShort();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] names = new String[]{"Justin"};
        String[] attendance = new String[]{"PAAPP"};

        String[] expected = new String[]{"Justin"};
        String[] actual = solution.shortList(names, attendance);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] names = new String[]{"Justin", "Chris"};
        String[] attendance = new String[]{"PAAPP", "PPPPA"};

        String[] expected = new String[]{"Justin"};
        String[] actual = solution.shortList(names, attendance);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] names = new String[]{"Sunny"};
        String[] attendance = new String[]{"PPPAM"};

        String[] expected = new String[]{};
        String[] actual = solution.shortList(names, attendance);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] names = new String[]{"Mansi", "Arjun", "Nikhil", "Taneja"};
        String[] attendance = new String[]{"PPPPMPPAPP", "AAMAAPP", "PPPPAAP", "PPPAAAMPP"};

        String[] expected = new String[]{"Arjun", "Nikhil", "Taneja"};
        String[] actual = solution.shortList(names, attendance);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] names = new String[]{};
        String[] attendance = new String[]{};

        String[] expected = new String[]{};
        String[] actual = solution.shortList(names, attendance);

        Assert.assertArrayEquals(expected, actual);
    }

}
