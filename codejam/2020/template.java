/*
 * 
 */
 import java.util.*;
 import java.io.*;

 class Solution {
 	//solve here
 	public static void main(String[] args) {
 		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 		int T = readInt(reader);
 		for (int tc = 0; tc < T; tc++) {
 			// read here
 			String s = Arrays.toString(readIntArray(reader));
 			System.out.printf("Case #%d : %s\n", tc + 1, s);
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
