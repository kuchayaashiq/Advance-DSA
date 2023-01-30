package ArrayListRecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		1. You are given a number n representing number of stairs in a staircase.
		2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
		3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
		Use sample input and output to take idea about output.
		
		Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
		Input Format
		A number n
		Output Format
		Contents of the arraylist containing paths as shown in sample output
		Constraints
		0 <= n <= 10
		Sample Input
		3
		Sample Output
		[111, 12, 21, 3]
		
 */
public class StairPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		sc.close();
		ArrayList<String> res = getStairPath(n);
		System.out.println(res);
				
	}

	private static ArrayList<String> getStairPath(int n) {
		
		// Base Case
		if(n == 0) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		else if (n < 0) {
			ArrayList<String> bres = new ArrayList<>();
			return bres;
		}
		
		ArrayList<String> paths1 = getStairPath(n-1);
		ArrayList<String> paths2 = getStairPath(n-2);
		ArrayList<String> paths3 = getStairPath(n-3);
		
		ArrayList<String> paths = new ArrayList<>();
		for (String p : paths1) {
			paths.add(1 + p);
		}
		for (String p : paths2) {
			paths.add(2 + p);
		}
		for (String p : paths3) {
			paths.add(3 + p);
		}
		return paths;
		
	}
}
