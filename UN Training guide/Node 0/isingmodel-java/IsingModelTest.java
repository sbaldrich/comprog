import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsingModelTest {

    protected IsingModel solution;

    @Before
    public void setUp() {
        solution = new IsingModel();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] spins = new String[]{"-++", "+-+"};

        int expected = 3;
        int actual = solution.energy(spins);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] spins = new String[]{"+"};

        int expected = 0;
        int actual = solution.energy(spins);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] spins = new String[]{"++-+", "-++-", "+-+-", "++++"};

        int expected = 4;
        int actual = solution.energy(spins);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] spins = new String[]{"----", "---+", "-+++", "++++"};

        int expected = -12;
        int actual = solution.energy(spins);

        Assert.assertEquals(expected, actual);
    }

}
