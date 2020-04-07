import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppleWordTest {

    protected AppleWord solution;

    @Before
    public void setUp() {
        solution = new AppleWord();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String word = "Apple";

        int expected = 0;
        int actual = solution.minRep(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String word = "apPpPPlE";

        int expected = 0;
        int actual = solution.minRep(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String word = "APLE";

        int expected = -1;
        int actual = solution.minRep(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String word = "TopCoder";

        int expected = 7;
        int actual = solution.minRep(word);

        Assert.assertEquals(expected, actual);
    }

}
