/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		347. Top K Frequent Elements
		Given an integer array nums and an integer k, return the k most frequent elements. 
		You may return the answer in any order.

		Example 1:
		
		Input: nums = [1,1,1,2,2,3], k = 2
		Output: [1,2]
		Example 2:
		
		Input: nums = [1], k = 1
		Output: [1]
		 
		
		Constraints:
		
		1 <= nums.length <= 105
		-104 <= nums[i] <= 104
		k is in the range [1, the number of unique elements in the array].
		It is guaranteed that the answer is unique.
		 
		
		Follow up: Your algorithm's time complexity must be better than O(n log n), 
		where n is the array's size.
 */
public class TopKFrequentElement347 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		int[] ans = topKFrequent(nums, k);
		for(int i : ans){
		    System.out.print(i+" ");
		}
    }
    public static int[] topKFrequent(int[] nums, int k) {
    	 // Frequency of every element 
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        
        // sort elements based on frequency 
       PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> (map.get(x) > map.get(y)) ? 1:-1);
        
        int numberOfElementInPQ = 0;
        for(Integer key: map.keySet())
        {
            if(numberOfElementInPQ<k)
            {
                numberOfElementInPQ++;
                pq.add(key);
            }
            else
            {
                if(map.get(key) > map.get(pq.peek()))
                {
                    // more deserving element 
                    pq.remove();
                    pq.add(key);
                }
            }
        }
        
        int ans[] = new int[k];
        int index = 0;
        while(!pq.isEmpty())
        {
            ans[index] = pq.poll();
            index++;
        }
        
        return ans;

    }
}
