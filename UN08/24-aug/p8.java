import java.io.*;
import java.util.*;
public class Main{

	private static boolean isNumber(String s){
		try{
			int x = Integer.parseInt(s);
			return true;
		}
		catch(Exception e){
			return false;
		}

	}

	public static File _f = new File("p9in.test");
	public static BufferedReader reader;
	public static void main(String args[]) throws Exception{
		if(_f.exists())
			reader = new BufferedReader(new FileReader(_f));
		else 
			reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while( (line = reader.readLine()) != null){
			if(line.trim().charAt(0) == '.')
				break;
			String list[] = line.split(", ");
			list[list.length - 1] =  list[list.length - 1].replaceAll("\\.","");
			boolean[] isnum = new boolean[list.length];
			Arrays.fill(isnum, false);
			ArrayList<Integer> nums = new ArrayList<Integer>();
			ArrayList<String> words = new ArrayList<String>();
			for(int i=0;i<list.length;i++ ){
				String s = list[i];
				if((isnum[i] = isNumber(s)))
					nums.add(Integer.parseInt(s));
				else 
					words.add(s);
			}
			Collections.sort(nums);
			Collections.sort(words, new Comparator<String>(){
				@Override
				public int compare(String a, String b){
					return a.toLowerCase().compareTo(b.toLowerCase());
				}
			});
			ArrayList<String> sorted = new ArrayList<String>();
			
			int nix = 0, wix= 0;
			for(int i=0;i<isnum.length;i++){
				if(isnum[i])
					sorted.add(String.valueOf(nums.get(nix++)));
				else 
					sorted.add(words.get(wix++));
			}
			for(int i=0;i<sorted.size();i++){
				if(i>0)
					System.out.print(", ");
				System.out.print(sorted.get(i));
			}
			System.out.println(".");
		}
		
	}
}
