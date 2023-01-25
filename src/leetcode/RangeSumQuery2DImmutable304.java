package leetcode;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *	QUESTION : 304. Range Sum Query 2D - Immutable 
	Given a 2D matrix matrix, handle multiple queries of the following type:
	
	Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
	Implement the NumMatrix class:
	
	NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
	int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
	You must design an algorithm where sumRegion works on O(1) time complexity.
	
	 
	
	Example 1: 
	3 0 1 4 2
	5 6 3 2 1
	1 2 0 1 5
	4 1 0 1 7
	1 0 3 0 5
	
	Input
	["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
	[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
	Output
	[null, 8, 11, 12]
	
	Explanation
	NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
	numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
	numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
	numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 */
public class RangeSumQuery2DImmutable304 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrix = new int [n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		NumMatrix(matrix);
		int ans = sumRegion(2, 1, 4, 3);
		System.out.println(ans);
		ans = sumRegion(1, 1, 2, 2);
		System.out.println(ans);
		ans = sumRegion(1, 2, 2, 4);
		System.out.println(ans);
	}
	    static int[][] prefix;  // matrix that stores sum of all rectangles of matrix
	    public static void  NumMatrix(int[][] matrix) {
	        int n =matrix.length;
	        int m = matrix[0].length;
	        prefix = new int[n][m];
	        
	        int sum = 0;
	        // Step 1 : initialize prefix matrix for 1st row
	        for(int i =0; i < m; i++){
	            sum += matrix[0][i];
	            prefix[0][i] = sum;
	        }
	        // Step 2 : initialize prefix matrix for 1st column
	        sum = 0;
	        for(int i =0; i < n; i++){
	            sum += matrix[i][0];
	            prefix[i][0] = sum;
	        }
	        // Step 3 : initialize prefix matrix for all other Elements
	        for(int i =1; i < n; i++){
	            for(int j = 1; j < m; j++){
	                prefix[i][j] = prefix[i][j-1] + prefix[i-1][j] + matrix[i][j] - prefix[i-1][j-1];
	            }
	        }
	    }
	    
	    public static int sumRegion(int r1, int c1, int r2, int c2) {
	     // USING Prefix 
	    // answer = prefix[r2][c2] -prefix[r2][c1-1] -prefix[r1-1][c2] +prefix[r1-1][c1-1]
	        
	        int ans = prefix[r2][c2];
	        if(c1 >= 1){        // prevents index out of bound exceptions
	            ans -= prefix[r2][c1-1];
	        }
	        if(r1 >= 1){
	            ans -= prefix[r1-1][c2];
	        }
	        if(r1 >= 1 && c1 >= 1){
	            ans += prefix[r1-1][c1-1];
	        }
	        return ans;
	    }
	

}
