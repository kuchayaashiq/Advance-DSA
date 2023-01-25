package basic;

import java.util.HashMap;
import java.util.Scanner;

public class StringChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(StringCheck(str1, str2));
	}

	private static String StringCheck(String str1, String str2) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			 hm.put(ch, hm.getOrDefault(ch,0) + 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			if(!hm.containsKey(ch)) {
				return "false";
			}
			else {
				if(hm.containsKey(ch) && hm.get(ch) > 1) {
					hm.put(ch,hm.get(ch) -1);
				}
				else {
					hm.remove(ch);
				}
			}
		}
		return "true";
	}

}
