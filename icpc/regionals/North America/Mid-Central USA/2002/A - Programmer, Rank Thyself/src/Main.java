import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Problem A - Programmer, Rank Thyself. 
 * Source: Mid-Central USA 2002 Regional Contest
 * author: sbaldrich
 * 
 * Ok, a really boring problem. Everything is pretty much given to you. One must be careful on formatting 
 * and mean calculation ( don't truncate till the very end ) I felt the responsibility of showing info was
 * better in the hands of each team, that's the reason for the Team class having so much to do.
 * O(i don't fuckin' want to know) 
 */
public class Main {

	public static class Team implements Comparable<Team> {
		String name;
		int times[] = new int[7];
		int problemsSolved;
		int totalTime;
		double mean;
		int finalMean;
		int time;
		int rank;

		Team(String line) {
			mean = 0;
			StringTokenizer tokenizer = new StringTokenizer(line);
			name = tokenizer.nextToken();
			for (int i = 0; i < 7; i++) {
				time = Integer.parseInt(tokenizer.nextToken());
				times[i]=time;
				totalTime += time;
				if (time > 0) {
					problemsSolved++;
					mean += Math.log(time);
				}
			}
			if (problemsSolved > 0) {
				mean /= problemsSolved;
				mean = Math.exp(mean);
				mean += 0.5;
				finalMean = (int) mean;
			}
		}

		public boolean sameRank(Team t) {
			if (this.problemsSolved == t.problemsSolved
					&& this.totalTime == t.totalTime
					&& this.finalMean == t.finalMean)
				return true;
			return false;
		}

		@Override
		public int compareTo(Team t) {
			if (this.problemsSolved > t.problemsSolved) 
				return -1;
			else if (this.problemsSolved < t.problemsSolved) 
				return 1;
			if (this.totalTime < t.totalTime)
				return -1;
			 else if (this.totalTime > t.totalTime) 
				return 1;
			
			if (this.finalMean < t.finalMean) 
				return -1;
			if (this.finalMean > t.finalMean) 
				return 1;
			return this.name.compareTo(t.name);
		}

		@Override
		public String toString() {
			return name;
		}

		public void dump() {
			System.out.printf((rank < 10 ? "0" : "") + "%d %-10s %d %4d %3d",
					rank, name, problemsSolved, totalTime, finalMean);
			for(int i=0;i<7;i++)
				System.out.printf("%4d",times[i]);
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf;
		File f = new File("A.in");
		if (f.exists())
			bf = new BufferedReader(new FileReader(f));
		else
			bf = new BufferedReader(new InputStreamReader(System.in));

		int teams;
		int z = 1;
		boolean flag = false;
		while (true) {
			teams = Integer.parseInt(bf.readLine().trim());
			if (teams == 0)
				break;
			if(flag)
				System.out.println();
			Team all[] = new Team[teams];
			for (int i = 0; i < teams; i++) {
				all[i] = new Team(bf.readLine());
			}
			Arrays.sort(all);
			int rank = 1;
			all[0].rank = 1;
			for (int i = 1; i < teams; i++) {
				if (all[i].sameRank(all[i - 1]))
					all[i].rank = rank;
				else 
					all[i].rank = rank = i + 1;
				
			}
			System.out.println("CONTEST " + (z++));
			for (int i = 0; i < teams; i++)
				all[i].dump();
				
		}

	}

}
