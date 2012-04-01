import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {


	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line, pars[];
		line = bf.readLine();
		int N = Integer.parseInt(line);
		while(N > 0)
		{
			int cherries[][] = new int[2*N][2];
			for(int i=0;i<2*N;i++)
			{
				line = bf.readLine();
				pars = line.split("\\s+");
				cherries[i][0] = Integer.parseInt(pars[0]);
				cherries[i][1] = Integer.parseInt(pars[1]);
			}
			
			int l,r,z;
			boolean done = false;
			for(int A=-500;A<=500 && !done;A++)
			{
				l = r = z = 0;
				for(int B=-500;B<=500 && !done;B++)
				{
					for(int i=0;i<2*N;i++)
					{
						int m = cherries[i][0]*A + cherries[i][1]*B; 
						if(m > 0)
							r++;
						else if(m<0)
							l++;
						else z++;
					}
					if(z == 0 && l==r)
					{
						System.out.printf("%d %d\n" ,A,B);
						done = true;
					}
				}
			}
			
		}
	}

}
