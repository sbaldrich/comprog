import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;


public class A {
	public static void main(String[] args) throws Exception{
		File f = new File("A.in");
		BufferedReader bf = new BufferedReader(new FileReader(f));
		String line;
		line  = bf.readLine();
		int n = Integer.parseInt(line.trim()),ans=0;
		int count[] = new int[26];
		for(int ncase = 1; ncase<=n;ncase++)
		{
			line = bf.readLine().trim().toLowerCase();
			Arrays.fill(count, 0);
			ans = 0;
			for(char c : line.toCharArray())
				try {
					count[c-'a']++;
				} catch (Exception e) {}
			Arrays.sort(count);
			for(int i=26;i>0;i--)
				ans+=i*count[i-1];
			System.out.printf("Case #%d: %d\n", ncase, ans);
		}
	}
}
