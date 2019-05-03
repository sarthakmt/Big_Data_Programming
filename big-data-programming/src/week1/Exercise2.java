package week1;

public class Exercise2 {
	
	/*
	 * Write a function that takes two string Sl and S2 at its input and returns a
	 * boolean denoting whether SI matches S2 S2 is a sequence of any number of the
	 * following: a-z - which stands for itself . (dot) - which matches 1 occurrence
	 * of any character *(star)- which matches O or more occurrences of the previous
	 * single character
	 */
	
	public static boolean isMatch(String str, String pattern) {

		int sLen = str.length();
		int pLen = pattern.length();
		int s = 0;
		int p = 0;
		int starIndex = -1; // index of star
		boolean yayOrNay = false;

		// condition check the char by char equality

		if (str == null || pattern == null || sLen == 0 || pLen == 0) {
			return false;
		}
		
		while (s < sLen) {
			// general match and dot found case
			//1. general case dot, just increment both s and p
			//2. if there is a dot and * together
			if (p < pLen && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '.')) {
				if (pattern.charAt(p) == '.' && pattern.charAt(p + 1) == '*') {
					yayOrNay = true;
					break;
				} else {
					s++;
					p++;
				}
			}

			// star found case
			//1. current char of S1 matches with previous char of S2(the char preceding the '*')
			//2. after increment of s, char of S1 matches with char next to '*' of S2
			//3. current char of S1 doesnot matche with current char of S2
			//4. if first char of S2 is '*'
			if (p < pLen && pattern.charAt(p) == '*' && p != 0) {
				starIndex = p;
				if (str.charAt(s) == pattern.charAt(starIndex - 1)) {
					s++;
					yayOrNay = true;
				} else if (p != pLen - 1 && str.charAt(s) == pattern.charAt(p + 1)) {
					s++;
					p = p + 2;
					yayOrNay = true;
				} else if (p != pLen - 1 && str.charAt(s) != pattern.charAt(p)) {
					// System.out.println("s: "+str.charAt(s)+ " p: "+pattern.charAt(p));
					s++;
					p++;
				} else {
					// System.out.println("s: "+str.charAt(s)+ " p: "+pattern.charAt(p));
					p++;
				}
			} else if (p < pLen && str.charAt(s) != pattern.charAt(p)) {
				p++;
				yayOrNay = false;
			} 
			 else if (p == pLen) {
				break;
			}
		}
		return yayOrNay;
	}

	public static void main(String[] args) {

		// String S1 = "abbaba";String S2 = "ab*a*b";
		// String S1 = "abbaba";String S2 = "ab*a*b*";
		// String S1 = "abbaba";String S2 = "ab*ac";
		// String S1 = "aba";String S2="*ab"; 
		// String S1 = "aa";String S2 = "a*";
		// String S1 = "ab";String S2=".*";
		// String S1 = "ab";String S2=".";
		// String S1 = "aab";String S2="c*a*b"; 
		// String S1 = "aaa";String S2="a*";
		// String S1 = "dcb";String S2 = "db";
		// String S1 = "dccccccb";String S2 = "dc*b";

		String[] S1List = { "abbaba", "abbaba", "abbaba", "aba", "ab", "aab", "aaa", "dcb", "dccccccb" };
		String[] S2List = { "ab*a*b", "ab*a*b*", "ab*ac", "*ab", ".*", "c*a*b", "a*", "db", "dc*b" };

		for (int i = 0; i < S1List.length; i++) {
			String S1 = S1List[i];
			String S2 = S2List[i];
			System.out.println("S1: " + S1 + " S2: " + S2 + "	" + isMatch(S1, S2));
		}

	}

}
