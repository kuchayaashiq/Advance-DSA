/**
 * 
 */
package stringsAndStringBuilder;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *
 */
public class PalindromicSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		for (int i = 0; i < str.length(); i++) {
			for (int j =i+1; j <= str.length(); j++) {
				
				if(isPalindromic(str.substring(i, j)))
					System.out.println(str.substring(i, j));
			}
		}
	}

	private static boolean isPalindromic(String str){
		// TODO Auto-generated method stub
		int i = 0;
		int j = str.length() - 1; 
		while(i < j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;				
			}
			i++;
			j--;
		}
		return true;
	}

}
