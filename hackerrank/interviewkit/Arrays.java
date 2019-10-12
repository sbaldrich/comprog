import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Scratch {
    static long repeatedString(String s, long n) {
        int m = s.length();
        int dp[] = new int[m + 1];
        for(int i = 1; i <= m; i++){
            dp[i] = dp[i - 1] + (s.charAt(i - 1) == 'a' ? 1 : 0);
        }
        return (n / m * dp[m]) + dp[(int)(n % m)];
    }

    static int dr[] = {-1, -1, -1, 0,  1, 1, 1};
    static int dc[] = {-1,  0,  1, 0, -1, 0, 1};
    static int hourglassSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int best = -1000;
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                int sum = 0;
                for(int k = 0; k < 7; k++) {
                    sum += arr[i + dr[k]][j + dc[k]];
                }
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int start = d % n;
        int j = 0;
        int[] out = new int[n];

        for (int i = start; i < n; i++, j++) {
            out[j] = a[i];
        }
        for (int i = 0; i < start; i++, j++) {
            out[j] = a[i];
        }
        return out;
    }


    static void minimumBribes(int[] q) {
        int ans = 0;
        int f = 1, s = 2, t = 3;

        for (int i = 0; i < q.length; i++, t++) {
            if(q[i] == f){
                f = s;
                s = t;
                continue;
            }
            if(q[i] == s){
                ans++;
                s = t;
                continue;
            }
            if(q[i] == t){
                ans += 2;
                continue;
            }
            System.out.println("Too chaotic");
            return;
        }
        System.out.println(ans);
    }

    static int cycleSize(boolean seen[], int arr[], int start){
        int p = start;
        int size = 0;
        while(!seen[p]){
            seen[p] = true;
            p = arr[p];
            size++;
        }
        return size;
    }

    static int minimumSwaps(int[] arr) {
        int n = arr.length;
        boolean seen[] = new boolean[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] != i && !seen[i]){
                ans += cycleSize(seen, arr, i) - 1;
            }
        }
        return ans;
    }

    static long arrayManipulation(int n, int[][] queries) {
        Map<Integer, Long> counts = new TreeMap<>();
        for(int i = 0, a, b, k; i < queries.length; i++){
            a = queries[i][0];
            b = queries[i][1] + 1;
            k = queries[i][2];
            counts.put(a, counts.getOrDefault(a,0L) + k);
            counts.put(b, counts.getOrDefault(b,0L) - k);
        }
        long ans = 0L;
        long sum = 0L;
        for (Long value : counts.values()) {
            sum += value;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
       long x = 1000000000L * 200000L;
       int y = 1000000000;
       System.out.println(x);
    }

}