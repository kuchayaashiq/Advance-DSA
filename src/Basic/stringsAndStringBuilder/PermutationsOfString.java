/**
 * 
 */
package stringsAndStringBuilder;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *
 */
public class PermutationsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		scn.close();
		
		solution(str);
	}

	private static void solution(String str) {
		// TODO Auto-generated method stub
		int n = str.length();
		int fact =  factorial(n);
		for (int i = 0; i < fact; i++) {
			StringBuilder sb = new StringBuilder(str);
			int temp = i;
			for (int div = str.length(); div >= 1; div--) {
				 int q = temp / div;
				 int r  = temp % div;
				 System.out.print(sb.charAt(r));
				 sb.deleteCharAt(r);
				 
				 temp = q;
			}
			System.out.println();
		}
	}

	private static int factorial(int n) {
		// TODO Auto-generated method stub
		int fact = 1;
		while(n > 1) {
			fact *= n;
			n--;
		}
		return fact;
	}

}
