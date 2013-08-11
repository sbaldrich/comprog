//310 - L--system
import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Main{
	private static BufferedReader reader;
	private static File _f = new File("input.txt");
	
	public static void main(String args[]) throws Exception{
		if(_f.exists())
			reader = new BufferedReader(new FileReader(_f));
		else 
			reader = new BufferedReader(new InputStreamReader(System.in));
		String aa,bb,start,goal,top,temp;
		LinkedList<String> queue;
		HashSet<String> visit;
		boolean possible = false;
		while((aa = reader.readLine())!=null){
			bb = reader.readLine();
			start = reader.readLine();
			goal = reader.readLine();
			queue = new LinkedList<String>();
			visit = new HashSet<String>();
			possible = false;
			queue.add(start);
			while(!queue.isEmpty()){
				top = queue.removeFirst();
				visit.add(top);
				//out.println(top);
				if(top.indexOf(goal) != -1){
					possible = true;
					break;
				}
				temp = top.replaceAll("a","x");
				temp = temp.replaceAll("b",bb);
				temp = temp.replaceAll("x",aa);
				if(!visit.contains(temp) && temp.length() <= 750)
					queue.add(temp);
			}
			out.println(possible?"YES":"NO");	
		}
	}
}
