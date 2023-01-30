package stringsAndStringBuilder;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
		1. You are given a string. 
		2. You have to compress the given string in the following two ways - 
		   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
		   For "aaabbccdee", the compressed string will be "abcde".
		   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
		   For "aaabbccdee", the compressed string will be "a3b2c2de2".
		Input Format
		A String
		Output Format
		Two strings representing first compressed string and second compressed string respectively.
		Constraints
		1 <= length of string <= 1000
		Sample Input
		wwwwaaadexxxxxx
		Sample Output
		wadex
		w4a3dex6
 */
public class StringComparison1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		String resStr1 = comparison1(str);
		System.out.println(resStr1);
		String resStr2 = comparison2(str);
		System.out.println(resStr2);
	}

	private static String comparison1(String str) {
		// TODO Auto-generated method stub
		String resString = str.substring(0, 1);
		for (int i = 1; i < str.length(); i++) {
			char curr =  str.charAt(i);
			char prev = str.charAt(i -1);
			if(curr != prev) {
				resString += curr;
			}
		}
		return resString;
	}
	private static String comparison2(String str) {
		// TODO Auto-generated method stub
		String resString = str.substring(0, 1);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			char curr =  str.charAt(i);
			char prev = str.charAt(i -1);
			if(curr == prev) {
				count++;
			}
			else {
				if(count > 1) {
					resString += count;
					count = 1;
				}
					
				resString += curr;
			}
			
		}
		if(count > 1) {
			resString += count;
			count = 1;
		}
		return resString;
	}

}
