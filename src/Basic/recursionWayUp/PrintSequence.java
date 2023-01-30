package recursionWayUp;

import java.util.Scanner;

public class PrintSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		sc.close();
		
		printSS(str, "");

	}

	private static void printSS(String str, String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String newStr = str.substring(1);
		
		printSS(newStr, ans + ch);
		printSS(newStr, ans+ "");
		
		
	}

}
