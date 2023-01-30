package ArrayListRecursion;

import java.util.ArrayList;
import java.util.Scanner;

import org.ietf.jgss.GSSContext;

public class GetSubSequences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		ArrayList<String> res = GSS(str);
		System.out.println(res);
				
	}

	private static ArrayList<String> GSS(String str) {
		// TODO Auto-generated method stub
		if(str.length() == 0) {
			ArrayList<String> bres = new ArrayList<String>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0);
		String s = str.substring(1);
		ArrayList<String> rres = GSS(s);
		ArrayList<String> myres = new ArrayList<String>();
		for (String rstr : rres) {
			myres.add("" + rstr);
		}
		for (String rstr : rres) {
			myres.add(ch + rstr);
		}
		
		return myres;
	}
}
