package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *	Given an array of intervals where intervals[i] = [starti, endi], 
 *  merge all overlapping intervals, and return an array of the non-overlapping 
 *  intervals that cover all the intervals in the input.

	Example 1:
	
	Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
	Output: [[1,6],[8,10],[15,18]]
	Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
	
	Example 2:
	
	Input: intervals = [[1,4],[4,5]]
	Output: [[1,5]]
	Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	 
	Constraints:
	
	1 <= intervals.length <= 104
	intervals[i].length == 2
	0 <= starti <= endi <= 104
 */
public class MergeIntervals56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] intervals = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				intervals[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int[][] ans = getMergedIntervals(intervals);
		for (int[] row : ans) {
			 System.out.println(Arrays.toString(row));
		}
	}

	private static int[][] getMergedIntervals(int[][] intervals) {
		
		// sort the array on the basis of 0th column in increasing or
		// sorted on the basis of starting point
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
		
		ArrayList<int[]> list  = new ArrayList<int[]>();
		for (int[] interval : intervals) {
			if(list.size() == 0) {
				list.add(interval);
			}else {
				int[] prevInterval = list.get(list.size() - 1);
				if(interval[0] <= prevInterval[1]) {
					prevInterval[1] = Math.max(prevInterval[1], interval[1]);
				}else {
					list.add(interval);
				}
			}
		}
		return list.toArray(new int[list.size()][]);
		
	}

}
