package ArrayListRecursion;

import java.util.ArrayList;
import java.util.Scanner;

public class KeypadCombinations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		ArrayList<String> res = getKPC(str);
		System.out.println(res);
				
	}
	static String codes[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
	private static ArrayList<String> getKPC(String str) {
		// TODO Auto-generated method stub
		if(str.length() == 0) {
			ArrayList<String> bres = new ArrayList<String>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0);
		String s = str.substring(1);
		ArrayList<String> rres = getKPC(s);
		ArrayList<String> myres = new ArrayList<String>();
		String codeforch = codes[ch - '0'];
		for (int i = 0; i < codeforch.length(); i++) {
			char code = codeforch.charAt(i);
			for (String rstr : rres) {
				myres.add(code + rstr);
			}
		}
		
		return myres;
	}
}
