import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheQuestionsAndAnswersDivTwoTest {

    protected TheQuestionsAndAnswersDivTwo solution;

    @Before
    public void setUp() {
        solution = new TheQuestionsAndAnswersDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] questions = new String[]{"How_are_you_doing?", "How_do_you_like_our_country?", "How_are_you_doing?"};

        int expected = 4;
        int actual = solution.find(questions);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] questions = new String[]{"Whazzup?"};

        int expected = 2;
        int actual = solution.find(questions);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] questions = new String[]{"Are_you_ready?", "Are_you_ready?", "Are_you_ready?", "Are_you_ready?"};

        int expected = 2;
        int actual = solution.find(questions);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] questions = new String[]{"Do_you_like_my_story?", "Do_you_like_my_story", "DO_YOU_LIKE_MY_STORY?", "Do__you__like__my__story?"};

        int expected = 16;
        int actual = solution.find(questions);

        Assert.assertEquals(expected, actual);
    }

}
