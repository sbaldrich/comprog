import java.io.*;
import java.util.*;

public class DuffAndWeights{

  static int MAX_SIZE = (int)1e6 * 2 + 1;

  public static void main(String args[]) throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(reader.readLine());
    int weights[] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer :: valueOf).toArray();
    int sum[] = new int[MAX_SIZE];

    for(int w : weights){
      sum[w]++;
    }

    int ans = 0;
    for(int i = 0; i < MAX_SIZE - 1; i++){
      if(sum[i] > 1){
        sum[i + 1] += sum[i] / 2;
        sum[i] %= 2;
      }
      if(sum[i] == 1){
        ans++;
      }
    }

    System.out.println(ans);
  }

}
