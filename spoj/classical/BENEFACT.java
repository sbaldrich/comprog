import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.Arrays;

/**
    https://www.spoj.com/problems/BENEFACT/

    Find the longest path between two nodes in a given tree, it can be solved by using DFS/BFS twice. 
    First starting from an arbitrary node (let's call that node s) to find the node farthest away from it (call the found node u). 
    Then another to get the farthest node from u (call this node v).The path between u and v is a longest path in the tree.
    
    
    The proof of why this works can be derived by contradiction, basically assuming that u is not part of a longest path.
    See https://stackoverflow.com/a/20014438/1898695 for more details. 
*/

class Main{

    static int[] dist;
    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException{
        // InputStream inputStream = new FileInputStream("BENEFACT.in");
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    static void dfs(int node, int parent, int distance){
        dist[node] = distance;
        for(int i = 0; i < graph.get(node).size(); i++){
            int[] next = graph.get(node).get(i);
            if(next[0] == parent){
                continue;
            }
            dfs(next[0], node, distance + next[1]);
        }
    }

    static int findMax(){
        int node = 0;
        int max = dist[0];
        for(int i = 1; i < dist.length; i++){
            if(max < dist[i]){
                node = i;
                max = dist[i];
            }
        }
        return node;
    }

    static void solve(InputReader in, PrintWriter out){
        int t,n,a,b,l;
        t = in.nextInt();
        while(t-- > 0){
            n = in.nextInt();
            dist = new int[n + 1];
            graph = new ArrayList<List<int[]>>();
            for(int i = 0; i < n; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < n - 1; i++){
                a = in.nextInt() - 1;
                b = in.nextInt() - 1;
                l = in.nextInt();
                graph.get(a).add(new int[]{b, l});
                graph.get(b).add(new int[]{a, l});
            }

            dfs(0, -1, 0);
            int u = findMax();
            dfs(u, -1, 0);
            int ans = dist[findMax()];
            out.println(ans);
        }
    }

    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream),  1 << 15);
            tokenizer = null;
        }

        public String next()  {
            while (tokenizer == null || !tokenizer.hasMoreElements()){
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException ex){
                    throw new RuntimeException(ex);
                }
                
            }
            return tokenizer.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

    }   
}