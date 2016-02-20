import java.util.Scanner;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import static java.lang.Math.max;

public class ACarefulApproach{

  static int[] start = new int[10];
  static int[] end = new int[10];
  static int n;
  static double best;

  private static void swap(int[] array, int p, int q){
    int r = array[p];
    array[p] = array[q];
    array[q] = r;
  }
  /**
  * Generate all permutations (in no particular order) of the given array and
  * perform the action described by the consumer on each one.
  * See https://en.wikipedia.org/wiki/Heap%27s_algorithm
  */
  static void solve(int n, int[] perm, Consumer<int[]> f ){
    if(n == 1){
      f.accept( perm );
    }
    else{
      for(int i=0; i < n - 1; i++){
        solve( n-1, perm, f);
        swap(perm, n % 2 == 0 ? i : 0, n - 1);
      }
      solve( n-1, perm, f);
    }
  }

  static boolean possible( int order[], double time ){
    double next = start[order[0]] + time;
    for( int i = 1; i < order.length; i++ ){
      if( next > end[order[i]])
        return false;
      if( next < start[order[i]] )
        next = start[order[i]] + time;
      else next += time;
    }
    return true;
  }

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int tc = 0;
    while(( n = sc.nextInt() ) != 0){
      best = 0.0;
      for(int i=0; i < n; i++){
        start[i] = 60 * sc.nextInt();
        end[i] = 60 * sc.nextInt();
      }
      double EPS = 1e-9;
      final Consumer<int[]> search = ( int[] order ) -> {
        double hi = 1440 * 60, lo = 1, mid;
        while( hi - lo > EPS ){
          mid = ( lo + hi ) / 2.0;
          if( possible( order, mid ) ){
            best = max( best, mid );
            lo = mid;
          }
          else{
            hi = mid;
          }
        }
      };

      solve(n, IntStream.range(0, n).toArray(), search);
      long ans = Math.round(best);
      System.out.printf("Case %d: %d:%02d\n", ++tc, ans / 60, ans - ans / 60 * 60);
    }
  }
}
