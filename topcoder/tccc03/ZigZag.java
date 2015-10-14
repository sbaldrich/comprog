public class ZigZag{
   public int longestZigZag(int[] seq){
    int n = seq.length, best = Integer.MIN_VALUE;
        boolean[] neg = new boolean[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
          if(i == 0)
                dp[i] = 1;
            else{
                for(int j=0; j < i; j++){
                    if(seq[j] == seq[i])
                        continue;
                    if( (dp[j] == 1 || neg[j] != seq[j] > seq[i]) && dp[i] < dp[j] + 1){
                      neg[i] = seq[j] > seq[i];
                        dp[i] = dp[j] + 1;  
                    }
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
  }
}