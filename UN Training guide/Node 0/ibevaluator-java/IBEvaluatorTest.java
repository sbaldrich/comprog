import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBEvaluatorTest {

    protected IBEvaluator solution;

    @Before
    public void setUp() {
        solution = new IBEvaluator();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] predictedGrades = new int[]{1, 5, 7, 3};
        int[] actualGrades = new int[]{3, 5, 4, 5};

        int[] expected = new int[]{25, 0, 50, 25, 0, 0, 0};
        int[] actual = solution.getSummary(predictedGrades, actualGrades);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] predictedGrades = new int[]{1, 1, 1};
        int[] actualGrades = new int[]{5, 6, 7};

        int[] expected = new int[]{0, 0, 0, 0, 33, 33, 33};
        int[] actual = solution.getSummary(predictedGrades, actualGrades);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] predictedGrades = new int[]{3};
        int[] actualGrades = new int[]{3};

        int[] expected = new int[]{100, 0, 0, 0, 0, 0, 0};
        int[] actual = solution.getSummary(predictedGrades, actualGrades);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] predictedGrades = new int[]{1, 5, 3, 5, 6, 4, 2, 5, 7, 6, 5, 2, 3, 4, 1, 4, 6, 5, 4, 7, 6, 6, 1};
        int[] actualGrades = new int[]{5, 1, 3, 2, 6, 4, 1, 7, 5, 2, 7, 4, 2, 6, 5, 7, 3, 1, 4, 6, 3, 1, 7};

        int[] expected = new int[]{17, 13, 21, 17, 21, 4, 4};
        int[] actual = solution.getSummary(predictedGrades, actualGrades);

        Assert.assertArrayEquals(expected, actual);
    }

}
