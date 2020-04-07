import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RabbitVotingTest {

    protected RabbitVoting solution;

    @Before
    public void setUp() {
        solution = new RabbitVoting();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] names = new String[]{"Alice", "Bill", "Carol", "Dick"};
        String[] votes = new String[]{"Bill", "Dick", "Alice", "Alice"};

        String expected = "Alice";
        String actual = solution.getWinner(names, votes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] names = new String[]{"Alice", "Bill", "Carol", "Dick"};
        String[] votes = new String[]{"Carol", "Carol", "Bill", "Bill"};

        String expected = "";
        String actual = solution.getWinner(names, votes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] names = new String[]{"Alice", "Bill", "Carol", "Dick"};
        String[] votes = new String[]{"Alice", "Alice", "Bill", "Bill"};

        String expected = "Bill";
        String actual = solution.getWinner(names, votes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] names = new String[]{"Alice", "Bill"};
        String[] votes = new String[]{"Alice", "Bill"};

        String expected = "";
        String actual = solution.getWinner(names, votes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] names = new String[]{"WhiteRabbit", "whiterabbit", "whiteRabbit", "Whiterabbit"};
        String[] votes = new String[]{"whiteRabbit", "whiteRabbit", "whiteRabbit", "WhiteRabbit"};

        String expected = "whiteRabbit";
        String actual = solution.getWinner(names, votes);

        Assert.assertEquals(expected, actual);
    }

}
