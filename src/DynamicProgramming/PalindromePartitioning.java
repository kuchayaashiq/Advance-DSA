package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;
/*
    Given a string s, partition s such that every string of the partition is a palindrome.
    Print all possible palindrome partitioning of s.
    Input Format
        First and only line of input contains a string 's'
    Output Format
        Print the list of all possible partitions in required sorted order.
    Example 1
        Input
         aab
        Output
          a a b
          aa b

*/
public class PalindromePartitioning {
    public static boolean[][] createIsPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int diag=0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // i==j
                    dp[i][j]=true;
                } else if(diag==1){ // i+1 == j
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                    }
                } else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        return dp;
    }

    public static void rec(String s, int si, int ei, ArrayList<ArrayList<String>> ans, ArrayList<String> curr,boolean[][] isPall){
        if(si>ei){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int cut=si; cut<=ei; cut++){
            if(isPall[si][cut]){
                curr.add(s.substring(si,cut+1));
                rec(s,cut+1,ei,ans,curr,isPall);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static ArrayList<ArrayList<String>> PalindromePartitioning(String s) {
        boolean[][] dp = createIsPalindrome(s);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();

        rec(s,0,s.length()-1,ans,curr,dp);
        return ans;
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<ArrayList<String>> ans = PalindromePartitioning(s);
        for(ArrayList<String> A :ans){
            for(String B : A)
            {
                System.out.print(B+" ");
            }
            System.out.println();
        }
    }
}
