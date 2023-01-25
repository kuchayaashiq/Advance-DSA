package leetcode;



import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		647. Palindromic Substrings
		Given a string s, return the number of palindromic substrings in it.
		
		A string is a palindrome when it reads the same backward as forward.
		
		A substring is a contiguous sequence of characters within the string.

		Example 1:
		
		Input: s = "abc"
		Output: 3
		Explanation: Three palindromic strings: "a", "b", "c".
		Example 2:
		
		Input: s = "aaa"
		Output: 6
		Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

		Constraints:
		
		1 <= s.length <= 1000
		s consists of lowercase English letters.
 */
public class PalindromicSubstrings647 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int ans = countSubstrings(str);
		System.out.println(ans);
	}
	public static int countSubstrings(String s) {
	        
	        int l = s.length();
	        
	        int ans = 0;
	        
	        // odd length palindromic substrings 
	        for(int middle=0;middle<l;middle++)
	        {
	            int left = middle-1;
	            int right = middle+1;
	            
	            int currentAns = 1;
	            while(left>=0 && right<l && s.charAt(left) == s.charAt(right))
	            {
	                currentAns++;
	                left--;
	                right++;
	            }
	            
	            ans+=currentAns;
	        }
	        
	        // even length palindromic substrings
	        for(int middle=0;middle<l;middle++)
	        {
	            int left = middle;
	            int right = middle+1;
	            
	            int currentAns = 0;
	            while(left>=0 && right<l && s.charAt(left) == s.charAt(right))
	            {
	                currentAns++;
	                left--;
	                right++;
	            }
	            
	            ans+=currentAns;
	        }
	        
	        return ans;
	    }

}
