import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheBlackJackDivTwoTest {

    protected TheBlackJackDivTwo solution;

    @Before
    public void setUp() {
        solution = new TheBlackJackDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] cards = new String[]{"4S", "7D"};

        int expected = 11;
        int actual = solution.score(cards);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] cards = new String[]{"KS", "TS", "QC"};

        int expected = 30;
        int actual = solution.score(cards);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] cards = new String[]{"AS", "AD", "AH", "AC"};

        int expected = 44;
        int actual = solution.score(cards);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] cards = new String[]{"3S", "KC", "AS", "7C", "TC", "9C", "4H", "4S", "2S"};

        int expected = 60;
        int actual = solution.score(cards);

        Assert.assertEquals(expected, actual);
    }

}
