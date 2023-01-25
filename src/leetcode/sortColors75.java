package leetcode;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		Question: 75. Sort Colors

		Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
		
		We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
		
		You must solve this problem without using the library's sort function.
		
		 
		
		Example 1:
		
		Input: nums = [2,0,2,1,1,0]
		Output: [0,0,1,1,2,2]
		Example 2:
		
		Input: nums = [2,0,1]
		Output: [0,1,2]
		 
		
		Constraints:
		
		n == nums.length
		1 <= n <= 300
		nums[i] is either 0, 1, or 2.
 */
public class sortColors75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		SortColors(nums);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	public static void SortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }
            else if(nums[i] == 1){
                one++;
            }
            else{
                two++;
            }
        }
        
        int idx = 0;
        int n = nums.length;
        while(idx < n && zero >0){
            nums[idx] = 0;
            zero--;
            idx++;
        }
        while(idx < n && one >0){
            nums[idx] = 1;
            one--;
            idx++;
        }
        while(idx < n && two >0){
            nums[idx] = 2;
            two--;
            idx++;
        }
        
    }

}
