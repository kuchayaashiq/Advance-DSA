/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		Question: 215. Kth Largest Element in an Array
		Given an integer array nums and an integer k, return the kth largest element in the array.
		
		Note that it is the kth largest element in the sorted order, not the kth distinct element.
		
		You must solve it in O(n) time complexity.
		
		 
		
		Example 1:
		
		Input: nums = [3,2,1,5,6,4], k = 2
		Output: 5
		Example 2:
		
		Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
		Output: 4
 */
public class KthLargestElementInArray215 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		sc.close();
		int ans = findKthLargest(nums, k);
		System.out.print(ans);
	}
	
	 public static int findKthLargest(int[] nums, int k) {
	        // approach 1:
	      //   Arrays.sort(nums);
	       
	       // int res = nums[(nums.length - k)];
	       // return res;
	        
	        
	        // Apprroach 2 : Best and Suitable approach
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        //step 1: Insert k elements in priority Queue(k logk)
	        
	        int n = nums.length;
	        for(int i = 0; i < k; i++){
	            pq.add(nums[i]);
	        }
	        //step 2: Iterating on (N- k) elements and do removal, insertion or skip part(N-K)logk
	        for(int i  = k; i < n; i++){
	           if(nums[i] > pq.peek()){
	               pq.remove();
	               pq.add(nums[i]);
	           }
	        }
	       return pq.peek();
	    }

}
