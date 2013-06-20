import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoccerLeaguesTest {

    protected SoccerLeagues solution;

    @Before
    public void setUp() {
        solution = new SoccerLeagues();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] matches = new String[]{"-WW", "W-W", "WW-"};

        int[] expected = new int[]{6, 6, 6};
        int[] actual = solution.points(matches);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] matches = new String[]{"-DD", "L-L", "WD-"};

        int[] expected = new int[]{5, 2, 8};
        int[] actual = solution.points(matches);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] matches = new String[]{"-DWWD", "L-WLL", "DD-WD", "DDL-L", "DDLL-"};

        int[] expected = new int[]{14, 7, 12, 8, 10};
        int[] actual = solution.points(matches);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] matches = new String[]{"-LWWLWDLDWWWWWWDDWDW", "D-WWLDDWDWDLWDDWLWDD", "LL-DLDWDLDLDWWWLWDDW", "LDD-LLLDLWLWWWWDWDWL", "LWWW-DWDLWDWDWWWDWDW", "DLLWD-WWLLDDDLWWDWWW", "WWLWDL-LLDWWWWWDWWLW", "LLLLLDW-LDLWDDLLLDWL", "DWWWWDDD-DWWWWDWWWDW", "WWWWLLLWL-LWWWWWLWWW", "DWWWWWWWLW-WDWWWWWWW", "DDDLLLDWWWL-DDWDWLDD", "LWLWLDLLLDLW-DDDWWDD", "LLWWLWDDLWLWL-WWWDLL", "WWWWLLDDDWLWDD-WWWLW", "DLDLLLWWLLLWWLW-DWLL", "DLWWWLDLWWDWWDWL-WWD", "LLDDLLWLLWLWLDLWW-WW", "LLWLLLWWLWLWWDWWLD-W", "LLWDLWDWDWLLWWDDWWL-"};

        int[] expected = new int[]{72, 62, 41, 41, 83, 63, 53, 35, 86, 50, 90, 32, 34, 41, 45, 36, 51, 32, 51, 45};
        int[] actual = solution.points(matches);

        Assert.assertArrayEquals(expected, actual);
    }

}
