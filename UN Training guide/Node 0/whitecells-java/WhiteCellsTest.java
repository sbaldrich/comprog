import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WhiteCellsTest {

    protected WhiteCells solution;

    @Before
    public void setUp() {
        solution = new WhiteCells();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"........", "........", "........", "........", "........", "........", "........", "........"};

        int expected = 0;
        int actual = solution.countOccupied(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF"};

        int expected = 32;
        int actual = solution.countOccupied(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{".F.F...F", "F...F.F.", "...F.F.F", "F.F...F.", ".F...F..", "F...F.F.", ".F.F.F.F", "..FF..F."};

        int expected = 1;
        int actual = solution.countOccupied(board);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"........", "..F.....", ".....F..", ".....F..", "........", "........", ".......F", ".F......"};

        int expected = 2;
        int actual = solution.countOccupied(board);

        Assert.assertEquals(expected, actual);
    }

}
