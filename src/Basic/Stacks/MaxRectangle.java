package Stacks;

import java.util.Scanner;
import java.util.Stack;

/*PROBLEM:
*   Given a binary matrix, your task is to calculate the maximum area of rectangle formed by only 1 in it.

    Input
            First line contains two integers number of rows N and number of columns M.
*            Next N lines contain M integers with each integer being either 0 or 1
*
* */
public class MaxRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int bMatrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bMatrix[i][j] = sc.nextInt();
            }
        }
        int ans = maxArea(bMatrix);
        System.out.println(ans);
    }

    private static int maxArea(int[][] bMatrix) {
        int currRow[] = bMatrix[0];
        int max = maxRectangle(currRow);
        for (int i = 1; i < bMatrix.length; i++) {
            for (int j = 0; j < bMatrix[0].length; j++) {
                if (bMatrix[i][j] == 1)
                    currRow[j] +=1;
                else
                    currRow[j] =0;
            }
            int curAns = maxRectangle(currRow);
            max = Math.max(max, curAns);
        }
        return max;
    }

    private static int maxRectangle(int[] currRow) {
        int maxArea =0;
        int ps[] = PreviousSmaller(currRow);
        int ns[] = NexttSmaller(currRow);

        for (int i = 0; i < currRow.length; i++) {
            int curr =(ns[i]- ps[i] - 1)*currRow[i];
            maxArea = Math.max(maxArea,curr);
        }
        return maxArea;
    }

    private static int[] NexttSmaller(int[] currRow) {
        int ns[] = new int[currRow.length];
        Stack<Integer> st =  new Stack<>();
        for (int i = currRow.length-1; i >=0 ; i--) {
            while (!st.empty() && currRow[st.peek()]>= currRow[i]) {
                st.pop();
            }
            if(st.empty()) {
                ns[i] =currRow.length;
            }
            else
                ns[i] =st.peek();
            st.push(i);
        }
        return ns;
    }

    private static int[] PreviousSmaller(int[] currRow) {
        int ps[] = new int[currRow.length];
        Stack<Integer> st =  new Stack<>();
        for (int i = 0; i <currRow.length ; i++) {
            while (!st.empty() && currRow[st.peek()] >= currRow[i]) {
                st.pop();
            }
            if(st.empty()) {
                ps[i] =-1;
            }
            else
                ps[i] =st.peek();
            st.push(i);
        }
        return ps;
    }
}
