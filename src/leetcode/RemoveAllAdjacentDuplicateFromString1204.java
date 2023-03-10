/**
 * 
 */
package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author KUCHAY_AASHIQ
 *	You are given a string s and an integer k, a k duplicate removal consists of 
 *  choosing k adjacent and equal letters from str and removing them, causing the 
 *  left and the right side of the deleted substring to concatenate together.

	We repeatedly make k duplicate removals on s until we no longer can.
	
	Return the final string after all such duplicate removals have been made. 
	It is guaranteed that the answer is unique.
	
	 
	
	Example 1:
	
	Input: s = "abcd", k = 2
	Output: "abcd"
	Explanation: There's nothing to delete.
	
	Example 2:
	
	Input: s = "deeedbbcccbdaa", k = 3
	Output: "aa"
	Explanation: 
	First delete "eee" and "ccc", get "ddbbbdaa"
	Then delete "bbb", get "dddaa"
	Finally delete "ddd", get "aa"
	
	Example 3:
	
	Input: s = "pbbcggttciiippooaais", k = 2
	Output: "ps"
 */
public class RemoveAllAdjacentDuplicateFromString1204 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		sc.close();
		String ans = RemoveDuplicates(str, k);
		System.out.println(ans);
		

	}

	private static String RemoveDuplicates(String str, int k) {
		Stack<int[]> st = new Stack<int[]>();
		for (char c : str.toCharArray()) {
			if(!st.isEmpty() && st.peek()[0] == c) {
				st.peek()[1]++;
			}
			else {
				st.push(new int[] {c,1});
			}
			if(st.peek()[1] == k) {
				st.pop();
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			int[] top = st.pop();
			while (top[1]-- > 0) {
				sb.append((char)top[0]);
			}
		}
		return sb.reverse().toString();
	}

}
