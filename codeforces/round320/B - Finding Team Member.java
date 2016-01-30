import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class FindingTeamMember {

  static BufferedReader in;
  static String pars[];
  static int n;
  static TreeSet<Team> teams = new TreeSet<>();
  
  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    readLine();
    int n = Integer.valueOf(pars[0]);
    int ans[] = new int[2*n];
    Arrays.fill(ans, -1);
    for (int i = 1; i <= 2 * n - 1; i++) {
      readLine();
      for (int j = 0; j < i; j++) {
        teams.add(new Team(j, i, Integer.valueOf(pars[j])));
      }
    }
    for (Team team : teams) {
      if(ans[team.memberA] == -1 && ans[team.memberB] == -1){
        ans[team.memberA] = team.memberB;
        ans[team.memberB] = team.memberA;
      }
    }
    for(int i = 0; i < 2*n; i++)
      System.out.print((i > 0 ? " " : "") + (ans[i] + 1) + (i == 2*n-1 ? "\n" : ""));
    
  }

  private static class Team implements Comparable<Team> {
    int memberA;
    int memberB;
    int strength;

    public Team(int memberA, int memberB, int strength) {
      this.memberA = memberA;
      this.memberB = memberB;
      this.strength = strength;
    }

    @Override
    public int compareTo(Team that) {
      return that.strength - this.strength;
    }

    @Override
    public String toString() {
      return String.format("[%d %d] = %d", memberA, memberB, strength);
    }
  }

  static void readLine() throws IOException {
    pars = in.readLine().split("\\s+");
  }
}
