package week1;

import java.util.ArrayList;

public class Exercise1 {

	/*
	 * Write a function that takes 2 strings S1 and S2 as its input and returns the
	 * longest common subsequence(LCS) of S1 and S2
	 *
	 * Edge Conditions: Only A-Z all in uppercase.
	 **/
	
	public static String longestCommonSubsequence(String S1, String S2) {
		StringBuffer LCS = new StringBuffer();
	
		char[] S1_array = S1.toCharArray();
		int init = 0;
		for (char s : S1_array) {
			for (int i = init; i < S2.length(); i++) {
				if (S2.charAt(i) == s) {
					LCS.append(s);
					init = i + 1;
					break;
				}
			}

		}
		return LCS.toString();
	}
	
	public static void main(String[] args) {

		String S1 = "ABAZDC";
		String S2 = "BACBAD";
		
		System.out.println(longestCommonSubsequence(S2,S1).length() > longestCommonSubsequence(S1,S2).length() ? longestCommonSubsequence(S2,S1) :longestCommonSubsequence(S1,S2));
	}

}
