import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilteringTest {

    protected Filtering solution;

    @Before
    public void setUp() {
        solution = new Filtering();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] sizes = new int[]{3, 4, 5, 6, 7};
        String outcome = "AAAAA";

        int[] expected = new int[]{3, 7};
        int[] actual = solution.designFilter(sizes, outcome);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] sizes = new int[]{3, 4, 5, 6, 7};
        String outcome = "AARAA";

        int[] expected = new int[]{};
        int[] actual = solution.designFilter(sizes, outcome);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] sizes = new int[]{3, 4, 5, 6, 7};
        String outcome = "RAAAA";

        int[] expected = new int[]{4, 7};
        int[] actual = solution.designFilter(sizes, outcome);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] sizes = new int[]{68, 57, 7, 41, 76, 53, 43, 77, 84, 52, 34, 48, 27, 75, 36};
        String outcome = "RARRRARRRARARRR";

        int[] expected = new int[]{48, 57};
        int[] actual = solution.designFilter(sizes, outcome);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] sizes = new int[]{26, 81, 9, 14, 43, 77, 55, 57, 12, 34, 29, 79, 40, 25, 50};
        String outcome = "ARAAARRARARARAA";

        int[] expected = new int[]{};
        int[] actual = solution.designFilter(sizes, outcome);

        Assert.assertArrayEquals(expected, actual);
    }

}
