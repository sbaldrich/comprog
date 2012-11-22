import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RelativePathTest {

    protected RelativePath solution;

    @Before
    public void setUp() {
        solution = new RelativePath();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String path = "/home/top/data/file";
        String currentDir = "/home/user/pictures";

        String expected = "../../top/data/file";
        String actual = solution.makeRelative(path, currentDir);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String path = "/home/user/movies/title";
        String currentDir = "/home/user/pictures";

        String expected = "../movies/title";
        String actual = solution.makeRelative(path, currentDir);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String path = "/file";
        String currentDir = "/";

        String expected = "file";
        String actual = solution.makeRelative(path, currentDir);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String path = "/a/b/a/b/a/b";
        String currentDir = "/a/b/a/a/b/a/b";

        String expected = "../../../../b/a/b";
        String actual = solution.makeRelative(path, currentDir);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String path = "/root/root/root";
        String currentDir = "/root";

        String expected = "root/root";
        String actual = solution.makeRelative(path, currentDir);

        Assert.assertEquals(expected, actual);
    }

}
