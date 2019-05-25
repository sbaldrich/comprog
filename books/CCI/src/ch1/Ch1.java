package ch1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
Type		Contains				Default	Size		Range

 boolean	true or false			false	1 bit		NA
 char		Unicode character		\u0000	16 bits		\u0000 to \uFFFF
 byte		Signed integer			0		8 bits		-128 to 127
 short		Signed integer			0		16 bits		-32768 to 32767
 int		Signed integer			0		32 bits		-2147483648 to 2147483647
 long		Signed integer			0		64 bits		-9223372036854775808 to 9223372036854775807
 float		IEEE 754 floating point	0.0		32 bits		±1.4E-45 to ±3.4028235E+38
 double		IEEE 754 floating point	0.0		64 bits		±4.9E-324 to ±1.7976931348623157E+308
 **/


public class Ch1{

	public static void main(String args[]){
		checkAssertionsAreOn();
		assert !stringHasUniqueCharacters("unique") : "Should be false";
		assert stringHasUniqueCharacters("unike") : "Should be true";
		assert !stringsArePermutationsOfOneAnother("unique", "nope") : "Should be false";
		assert stringsArePermutationsOfOneAnother("unique", "equuni") : "Should be true";
		assert Arrays.equals(spaceEncodingInPlace("Mr John Smith    ".toCharArray()), "Mr%20John%20Smith".toCharArray()) : "Should be true";
		assert Arrays.equals(spaceEncodingInPlace("   ".toCharArray()), "%20".toCharArray()) : "Should be true";
		assert Arrays.equals(spaceEncodingInPlace("% 2 0    ".toCharArray()), "%%202%200".toCharArray()) : "Should be true";
		assert compress("aaabbbcccdaabbb").equals("a3b3c3d1a2b3") : "Should be true";
		assert compress("abc").equals("abc") : "Should be true";

		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] expected = {{1,0,1},{0,0,0},{1,0,1}};

		rowColToZeroIfElementIsZero(matrix);

		for(int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++) {
				assert matrix[i][j] == expected[i][j] : String.format("Element (%d,%d) is not a match", i, j);
			}
		}


		assert isRotation("watterbottle","erbottlewat") : "Should be true";
		assert ! isRotation("watterbottle","erbottleatw") : "Should be false";

		System.out.println("Finished, all good.");
	}

	public static boolean stringHasUniqueCharacters(final String string){

		// Using streams O(n*lg(n))
		boolean option1 = string.chars().distinct().count() == string.length();

		// Using additional data structures O(n*lg(n))
		HashSet<Character> seenChars = new HashSet<>();
		for(char c : string.toCharArray()){
			seenChars.add(c);
		}

		boolean option2 = seenChars.size() == string.length();

		// Without using additional data structures: O(n²)
		boolean option3 = true;
		int n = string.length();
		char[] chars = string.toCharArray();
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				if(chars[i] == chars[j]){
					option3 = false;
					break;
				}
			}
		}

		// The string is ASCII encoded
		boolean option4 = true;
		if (string.length() > 256) {
			option4 = false; // Cuz pigeons.
		} else {

			boolean[] seen = new boolean[256];
			for (char c : string.toCharArray()) {
				if (seen[c]) {
					option4 = false;
					break;
				}
				seen[c] = true;
			}
		}



		assert option1 == option2 && option2 == option3 && option3 == option4;
		return option1;
	}

	public static boolean stringsArePermutationsOfOneAnother(final String first, final String second){


		// Sorting and comparing: O(n*lg(n)) + O(n) = O(n*lg(n))
		boolean option1 = false;
		char[] firstArray = first.toCharArray();
		char[] secondArray = second.toCharArray();
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		option1 = Arrays.equals(firstArray, secondArray);

		return option1;

	}

	public static char[] spaceEncodingInPlace(char[] array){
		// Using no other space O(n²)
		for(int i = 0; i < array.length; i++){
			if(array[i] == ' '){
				for(int j = array.length - 3; j > i; j--){
					array[j + 2] = array[j];
				}
				array[i] = '%';
				array[i + 1] = '2';
				array[i + 2] = '0';
				i += 3;
			}
		}
		return array;
	}

	public static String compress(String string){
		char[] chars = string.toCharArray();
		StringBuffer buffer = new StringBuffer();
		for(int i = 0, j; i < chars.length; i++){
			for(j = i + 1; j < chars.length && chars[i] == chars[j]; j++){}
			buffer.append(chars[i]).append(j - i);
			i = j - 1;
		}
		return buffer.length() > string.length() ? string : buffer.toString();
	}

	public static void rowColToZeroIfElementIsZero(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		Set<Integer> cols = new HashSet<>();
		Set<Integer> rows = new HashSet<>();
		for(int i = 0; i < m; i++ ) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == 0){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (Integer col : cols) {
			for (int i = 0; i < m; i++) {
				matrix[i][col] = 0;
			}
		}
		for (Integer row : rows) {
			for (int i = 0; i < n; i++) {
				matrix[row][i] = 0;
			}
		}
	}

	public static boolean isRotation(String s1, String s2){
		return s1.concat(s1).contains(s2);
	}

	private static void checkAssertionsAreOn(){
		boolean assertEnabled = false;
		assert assertEnabled = true;
		if(!assertEnabled){
			System.err.println("You should be running this code with assertions enabled.");
			System.exit(-1);
		}

	}
}
