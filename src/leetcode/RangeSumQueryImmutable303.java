/**
 * 
 */
package leetcode;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *	Given an integer array nums, handle multiple queries of the following type:

	Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
	Implement the NumArray class:
	
	NumArray(int[] nums) Initializes the object with the integer array nums.
	int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
	 
	
	Example 1:
	
	Input
	["NumArray", "sumRange", "sumRange", "sumRange"]
	[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
	Output
	[null, 1, -1, -3]

 */
public class RangeSumQueryImmutable303 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int [n];
		for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
		}
		sc.close();
		NumArray(nums);
		int ans = sumRange(0, 2);
		System.out.println(ans);
		ans = sumRange(2, 5);
		System.out.println(ans);
		ans = sumRange(0, 5);
		System.out.println(ans);
	}
	static int[] prefix;
    public static void NumArray(int[] nums) {
          int n =nums.length;
	      prefix = new int[n+1];
        int sum = 0;
        for(int i = 1; i < prefix.length; i ++){
            sum += nums[i - 1];
            prefix[i] = sum;
        }
    }
	public static int sumRange(int left, int right) {
        int ans = prefix[right + 1] - prefix[left];
        return ans;
    }

}
