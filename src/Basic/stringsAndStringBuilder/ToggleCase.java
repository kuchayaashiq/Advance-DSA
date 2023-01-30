/**
 * 
 */
package stringsAndStringBuilder;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		1. You are given a string that contains only lowercase and uppercase alphabets. 
		2. You have to toggle the case of every character of the given string.
		Input Format
		A String
		Output Format
		A String
		Constraints
		1 <= length of string <= 1000
		Sample Input
		pepCODinG
		Sample Output
		PEPcodINg
		
 */
public class ToggleCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String  str = sc.next();
		sc.close();
		String res =  toggleCase(str);
		System.out.println(res);
	}

	private static String toggleCase(String str) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < str.length(); i++) {
			char ch = sb.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				char uch = (char)('A' + ch - 'a');
				sb.setCharAt(i, uch);
			}
			else if(ch >= 'A' && ch <= 'Z') {
				char lch = (char)('a' + ch - 'A');
				sb.setCharAt(i, lch);
			}
		}
		return sb.toString();
	}

}
