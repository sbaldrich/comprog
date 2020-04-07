import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassingGradeTest {

    protected PassingGrade solution;

    @Before
    public void setUp() {
        solution = new PassingGrade();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] pointsEarned = new int[]{55, 77, 82, 60};
        int[] pointsPossible = new int[]{100, 100, 100, 100};
        int finalExam = 300;

        int expected = 181;
        int actual = solution.pointsNeeded(pointsEarned, pointsPossible, finalExam);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] pointsEarned = new int[]{1, 2, 3, 4};
        int[] pointsPossible = new int[]{2, 3, 4, 5};
        int finalExam = 7;

        int expected = 4;
        int actual = solution.pointsNeeded(pointsEarned, pointsPossible, finalExam);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] pointsEarned = new int[]{1, 2, 2, 1};
        int[] pointsPossible = new int[]{9, 9, 9, 9};
        int finalExam = 9;

        int expected = -1;
        int actual = solution.pointsNeeded(pointsEarned, pointsPossible, finalExam);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] pointsEarned = new int[]{7, 8, 7, 6};
        int[] pointsPossible = new int[]{8, 8, 8, 8};
        int finalExam = 9;

        int expected = 0;
        int actual = solution.pointsNeeded(pointsEarned, pointsPossible, finalExam);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] pointsEarned = new int[]{17, 23, 50, 200, 19, 56, 83, 91, 77, 9, 0};
        int[] pointsPossible = new int[]{20, 30, 50, 250, 20, 70, 100, 100, 100, 10, 10};
        int finalExam = 400;

        int expected = 129;
        int actual = solution.pointsNeeded(pointsEarned, pointsPossible, finalExam);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] pointsEarned = new int[]{600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600};
        int[] pointsPossible = new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 901};
        int finalExam = 3000;

        int expected = 2886;
        int actual = solution.pointsNeeded(pointsEarned, pointsPossible, finalExam);

        Assert.assertEquals(expected, actual);
    }

}
