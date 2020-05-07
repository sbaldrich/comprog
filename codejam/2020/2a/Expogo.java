
/*
 * 
 */
 import java.util.*;
 import java.io.*;

 class Solution {

	static class Node {
		long x;
		long y;
		String path;
		Node(long x, long y, String path){
			this.x = x;
			this.y = y;
			this.path = path;
		}
	}
	static char[] ds = {'N', 'E', 'S', 'W'};
	static int[] dx = {0,   1,   0,   -1};
	static int[] dy = {1,   0,   -1, 0};

	static Node solve(long x, long y) {
		Queue<Node> queue = new LinkedList<>();
		Set<Integer> seen = new HashSet<>();
		queue.add(new Node(0, 0, ""));
		while(!queue.isEmpty()){
			Node p = queue.remove();
			if(p.x == x && p.y == y)
				return p;
			seen.add(Objects.hash(p.x, p.y));
			long delta = 1L << (long) p.path.length();
			for (int i = 0; i < 4; i++) {
				Node q = new Node(p.x + dx[i] * delta, p.y + dy[i] * delta, p.path + ds[i]);
				int h = Objects.hash(q.x, q.y);
				if(!seen.contains(h) && Math.abs(q.x) < 1001 && Math.abs(q.y) < 1001){
					queue.add(q);
				}
			}
		}
		return new Node(x, y, "IMPOSSIBLE");
	}

 	public static void main(String[] args) throws IOException {
 		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 		int T = readInt(reader);
 		for (int tc = 0; tc < T; tc++) {
			long[] pars = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
 			Node ans = solve(pars[0], pars[1]);
 			System.out.printf("Case #%d: %s\n", tc + 1, ans.path);
 		}
 	}

 	static String readLine(BufferedReader reader){
 		try {
 			return reader.readLine();
 		} catch(IOException e){
 			throw new RuntimeException(e);
 		}
 	}

 	static int readInt(BufferedReader reader){
 		return Integer.parseInt(readLine(reader));
 	}

 	static int[] readIntArray(BufferedReader reader){
 		return Arrays.stream(readLine(reader).trim().split("\\s+"))
 			.mapToInt(Integer::parseInt)
 			.toArray();
 	}
 }
