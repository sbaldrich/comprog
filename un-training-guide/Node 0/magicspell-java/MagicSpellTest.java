import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicSpellTest {

    protected MagicSpell solution;

    @Before
    public void setUp() {
        solution = new MagicSpell();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String spell = "AZ";

        String expected = "ZA";
        String actual = solution.fixTheSpell(spell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String spell = "ABACADA";

        String expected = "ABACADA";
        String actual = solution.fixTheSpell(spell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String spell = "AABZCADZA";

        String expected = "AZBACZDAA";
        String actual = solution.fixTheSpell(spell);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String spell = "AZBASGHNAZAHBNVZZGGGAGGZAZ";

        String expected = "ZABZSGHNAZZHBNVAZGGGAGGAZA";
        String actual = solution.fixTheSpell(spell);

        Assert.assertEquals(expected, actual);
    }

}
