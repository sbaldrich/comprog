import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChatTranscriptTest {

    protected ChatTranscript solution;

    @Before
    public void setUp() {
        solution = new ChatTranscript();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] transcript = new String[]{"Bob: Hello Tim.", "Tim: Hello Bob.", "Bob: How are ya Tim?", "Frank: Stop chatting!"};
        String name = "Bob";

        int expected = 2;
        int actual = solution.howMany(transcript, name);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] transcript = new String[]{"Bob: This is a long", "sentence that takes 2 lines.", "Tim: Yes it is.", "Bob : I am not Bob.", "Frank: No you aren't!", " Bob: Neither am I."};
        String name = "Bob";

        int expected = 1;
        int actual = solution.howMany(transcript, name);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] transcript = new String[]{"Crazy1010: !@LK%#L%K @#L%K @#L%K@#L%K2kl53k2", "Bob: You are crazy.", "Crazy1010 Yup #@LK%$L!K%LK%!K% !K afmas,"};
        String name = "Crazy1010";

        int expected = 1;
        int actual = solution.howMany(transcript, name);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] transcript = new String[]{"A:A:A:A:A:A:A:A:A", "b:b:b:b:b:b:b:b:b"};
        String name = "B";

        int expected = 0;
        int actual = solution.howMany(transcript, name);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] transcript = new String[]{"A:A:A:A:A:A:A:A:A"};
        String name = "A";

        int expected = 1;
        int actual = solution.howMany(transcript, name);

        Assert.assertEquals(expected, actual);
    }

}
