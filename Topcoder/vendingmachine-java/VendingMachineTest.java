import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    protected VendingMachine solution;

    @Before
    public void setUp() {
        solution = new VendingMachine();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] prices = new String[]{"100 100 100"};
        String[] purchases = new String[]{"0,0:0", "0,2:5", "0,1:10"};

        int expected = 4;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }
    

    @Test(timeout = 2000)
    public void testCase1() {
        String[] prices = new String[]{"100 200 300 400 500 600"};
        String[] purchases = new String[]{"0,2:0", "0,3:5", "0,1:10", "0,4:15"};

        int expected = 17;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] prices = new String[]{"100 200 300 400 500 600"};
        String[] purchases = new String[]{"0,2:0", "0,3:4", "0,1:8", "0,4:12"};

        int expected = 11;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] prices = new String[]{"100 100 100"};
        String[] purchases = new String[]{"0,0:10", "0,0:11"};

        int expected = -1;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] prices = new String[]{"100 200 300", "600 500 400" , "1 1 1"};
        String[] purchases = new String[]{"0,0:0", "1,1:10", "1,2:20", "0,1:21", "1,0:22", "0,2:35"};

        int expected = 6;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }
    @Test(timeout = 2000)
    public void testCase5() {
        String[] prices = new String[]{"9 284 4 8 5 5 533 7566 4491 132 3146 7 1391 8 11 2", "4 1 5 1597 9805 5500 6757 2921 8 2 95 1 9 4 5 6956", "9394 3311 819 3836 26 3537 8 5 1 90 1 7 4 7 1739 8", "8029 16 7 8 5 2 4 5 1 1 6 4978 5699 4309 5834 8036", "8900 1020 7630 7796 3 552 9 8 2 7860 4 16 9 4 44 1", "9 1340 4 3962 4 3171 5405 6312 4 9 6 4 4 1 813 917", "2420 7 3 8 2452 3216 5 3 9 9 8083 58 6 4 3871 9864", "8 4 9 4230 4 8034 9963 6703 4 9 9317 6 2 2998 91 9", "5 5820 7010 6 4 15 9 4009 8339 4 1376 3 6 6877 1 3", "3 8949 7 4664 545 5 1 5 3 462 3476 5 4697 7925 6 1", "4 5 6795 3193 424 870 2257 5 4 1 9 8 3669 6 3405 6", "93 1 4 5810 9689 7 5 3 9950 6616 2168 1 6 1 9 5348", "4890 385 1 5 9 8 9 8 566 1 3413 4 5256 5 5645 5678", "3 647 9596 3992 7096 1081 80 3 6 8 5 3 4 5 7251 21"};
        String[] purchases = new String[]{"13,7:5", "12,10:10", "4,15:15", "5,15:16", "5,11:21", "9,12:26", "11,6:31", "7,15:36", "8,12:37", "7,2:38", "6,0:43", "11,7:44", "3,5:49", "13,13:54", "9,7:59", "4,7:64", "9,11:69", "11,9:74", "12,13:79", "9,4:84"};

        int expected = 171;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }
     
    @Test(timeout = 2000)
    public void testCase6() {
        String[] prices = new String[] 	{"1 1 5 1 1"};
        String[] purchases = new String[]  {"0,0:0"};

        int expected = 6;
        int actual = solution.motorUse(prices, purchases);

        Assert.assertEquals(expected, actual);
    }
}
