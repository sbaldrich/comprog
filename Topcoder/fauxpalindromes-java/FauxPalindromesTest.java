import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FauxPalindromesTest {

    protected FauxPalindromes solution;

    @Before
    public void setUp() {
        solution = new FauxPalindromes();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String word = "ANA";

        String expected = "PALINDROME";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String word = "AAAAANNAA";

        String expected = "FAUX";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String word = "LEGENDARY";

        String expected = "NOT EVEN FAUX";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String word = "XXXYTYYTTYX";

        String expected = "FAUX";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String word = "TOPCOODEREDOOCPOT";

        String expected = "PALINDROME";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String word = "TOPCODEREDOOCPOT";

        String expected = "FAUX";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        String word = "XXXXYYYYYZZXXYYY";

        String expected = "NOT EVEN FAUX";
        String actual = solution.classifyIt(word);

        Assert.assertEquals(expected, actual);
    }

}
