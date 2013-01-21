import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessboardTest {

    protected Chessboard solution;

    @Before
    public void setUp() {
        solution = new Chessboard();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String cell = "1";

        String expected = "a1";
        String actual = solution.changeNotation(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String cell = "2";

        String expected = "b1";
        String actual = solution.changeNotation(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String cell = "26";

        String expected = "b4";
        String actual = solution.changeNotation(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String cell = "c1";

        String expected = "3";
        String actual = solution.changeNotation(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String cell = "e4";

        String expected = "29";
        String actual = solution.changeNotation(cell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String cell = "h8";

        String expected = "64";
        String actual = solution.changeNotation(cell);

        Assert.assertEquals(expected, actual);
    }

}
