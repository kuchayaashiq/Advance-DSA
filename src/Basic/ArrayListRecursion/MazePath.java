/**
 * 
 */
package ArrayListRecursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		1. You are given a number n and a number m representing number of rows and columns in a maze.
		2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
		3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
		Use sample input and output to take idea about output.
		
		Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
		Input Format
		A number n
		A number m
		Output Format
		Contents of the arraylist containing paths as shown in sample output
		Constraints
		0 <= n <= 10
		0 <= m <= 10
		Sample Input
		3
		3
		Sample Output
		[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]		
 *
 */
public class MazePath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		ArrayList<String> ans = getMazePath(1, 1, n, m);
		int size = ans.size();
		System.out.println(ans);
		System.out.println(size);
	}
	// sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
	private static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {
		if(sr == dr && sc == dc) {
			ArrayList<String> bpaths = new ArrayList<String>();
			bpaths.add("");
			return bpaths;
		}
		ArrayList<String> hpaths = new ArrayList<String>();
		ArrayList<String> vpaths = new ArrayList<String>();
		
		if(sc <= dc) {
			hpaths = getMazePath(sr, sc +1, dr, dc);
		}
		if(sr <= dr) {
			vpaths = getMazePath(sr + 1, sc, dr, dc);
		}
		ArrayList<String> paths = new ArrayList<String>();
		for (String hpath : hpaths) {
			paths.add("h" + hpath);
		}
		for (String vpath : vpaths) {
			paths.add("v" + vpath);
		}
		
		return paths;
	}

}
