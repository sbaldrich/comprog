import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    int[] a = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer :: parseInt).toArray();
    sc.close();
    int best = 1, current = 1;
    for(int i = 1; i < n; i++){
      if(a[i] >= a[i-1]){
        current++;
      }
      else{
        best = Math.max(best, current);
        current = 1;
      }
    }
    best = Math.max(best, current);
    System.out.println(best);
  }
} 
