import java.util.*;
import java.text.DecimalFormat;

public class CellphoneTyping{

  public static class Trie{
    boolean end;
    Trie[] next;
    int out = 0;

    Trie(){
      this(0);
    }
    private Trie(int c){
      next = new Trie[26];
    }

    Trie add(String word){
      return add(word.chars().map(c -> c - 'a').toArray(), 0);
    }

    private Trie add(int[] w, int i){
      if(i == w.length){
        end = true;
        return this;
      }
      if(next[w[i]] == null){
        next[w[i]] = new Trie(w[i]);
        out++;
      }
      return next[w[i]].add(w, i + 1);
    }

    int strokes(String word){
      return strokes(word.chars().map(c -> c - 'a').toArray(), 0, 0);
    }

    private int strokes(int[] w, int i, int s){
      if(i == w.length)
        return s;
      return s > 0 && out == 1 && !end ? next[w[i]].strokes(w, i+1, s) : next[w[i]].strokes(w, i+1, s+1);
    }

  }

  public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    List<String> words = new ArrayList<>();
    while(sc.hasNext()){
      words.clear();
      int n = sc.nextInt();
      Trie t = new Trie();
      for(int i = 0; i < n; i++){
        String word = sc.next();
        words.add(word);
        t.add(word);
      }
      double ans = 0.0;
      for(String word : words)
        ans += t.strokes(word);
      System.out.println(df.format(ans / n));
    }
  }

}
