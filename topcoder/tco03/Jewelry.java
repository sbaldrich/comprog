import java.util.*;

public class Jewelry{

  int maxs = 1000 * 30;
  static final int maxe = 30;
  static long[][] C = new long[maxe + 1][maxe + 1]; // Binomial coefficients

  static {
    for(int i = 0; i <= maxe; i++){
      C[i][0] = 1;
      for( int j = 1; j <= i; j++ )
        C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
  }
  }

  long [][] prefSums = new long[maxs + 1][31]; // dp[s][i]: How many ways can I choose from the i first elements to make sum s?
  long [][] suffSums = new long[maxs + 1][31]; // dp[s][i]: How many ways can I choose from the i last elements to make sum s?

  public long howMany(int[] jewels){
    int n = jewels.length;
    Arrays.sort(jewels);
    prefSums[0][0] = suffSums[0][0] = 1;
    for(int s = 0; s <= maxs; s++){
      for(int i = 1; i <= n; i++){
        prefSums[s][i] = prefSums[s][i-1];
        if(s >= jewels[i - 1])
            prefSums[s][i] += prefSums[s - jewels[i-1]][i-1];
        suffSums[s][i] = suffSums[s][i-1];
        if(s >= jewels[n - i])
            suffSums[s][i] += suffSums[s - jewels[n-i]][i-1];
      }
    }


    long ans = 0;
    for(int i = 0; i < n; i++){
      int sz = 1;
      while(i + sz < n && jewels[i] == jewels[i + sz]) sz++;
      for(int j = i; j <= (i + sz - 1); j++){
        for(int s = (j - i + 1) * jewels[i]; s <= maxs; s++)
          ans += C[sz][j - i + 1] * prefSums[s - (j - i + 1) * jewels[i]][i] * suffSums[s][n - j - 1];
      }
      i += sz - 1;
    }

    return ans;
  }
}
