import java.util.*;

public class KefaAndPark {

  static ArrayList<ArrayList<Integer>> graph;
  static boolean hasCat[];
  static int n, m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    
    graph = new ArrayList<ArrayList<Integer>>();
    hasCat = new boolean[n];
    
    for(int i=0; i < n; i++){
      hasCat[i] = sc.nextInt() == 1;
      graph.add(new ArrayList<Integer>());
    }
    
    for(int i=0, u, v; i < n - 1; i++){
      u = sc.nextInt() - 1;
      v = sc.nextInt() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    sc.close();
    System.out.println(dfs(0, 0, -1));
  }
  
  static int dfs(int p, int catcount, int parent){
    if(catcount == m && hasCat[p])
      return 0;
    if(parent != -1 && graph.get(p).size() == 1)
      return 1;
    int answer = 0;
    for(int child : graph.get(p))
      if(child != parent)
        answer += dfs(child, (hasCat[p] ? catcount + 1 : 0), p);
    return answer;
  } 
}