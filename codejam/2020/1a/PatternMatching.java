import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution{

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int c = 1; c <= T; c++) {
			int N = Integer.parseInt(reader.readLine());
			List<String> strings = new ArrayList<>(N);
			List<String> prefixes = new ArrayList<>();	
			List<String> suffixes = new ArrayList<>();
			List<String> middles = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String p = reader.readLine();
				int fr = p.indexOf('*');
				int to = p.lastIndexOf('*');
				String prefix = p.substring(0, fr);
				String suffix = p.substring(to + 1, p.length());
				String middle = to == fr ? "" : p.substring(fr + 1, to);

				prefixes.add(prefix);
				suffixes.add(suffix);
				middles.add(middle);
			}
			String longestPrefix = prefixes.stream().max(Comparator.comparing(String::length)).orElse("");
			String longestSuffix = suffixes.stream().max(Comparator.comparing(String::length)).orElse("");
			boolean ok = prefixes.stream().allMatch(it -> longestPrefix.startsWith(it));
			ok = ok && suffixes.stream().allMatch(it -> longestSuffix.endsWith(it));
			String ans = "*";
			if(ok){
				String middle = middles.stream()
					.map(it -> it.replaceAll("\\*", ""))
					.collect(Collectors.joining(""));
				ans = longestPrefix + middle + longestSuffix;
			}
			System.out.printf("Case #%d: %s\n", c, ans);

		}
	}

	
}
