package DynamicProgramming.StringDP;

import java.util.Scanner;
        /*
                You are given a string S, Your task is to count number of subsequences
                of the form aibjck, where i >= 1, j >=1 and k >= 1.
                Note:
                Two subsequences are considered different if the set of array indexes picked for the
                2 subsequences are different.
                For large test cases, the output value will be too large, return the answer MODULO 10^9+7
                Note : You don't need to read input or print anything. Your task is to complete the
                function fun() which takes the string S as input parameter and returns the number
                subsequences which follows given condition.
                Input Format
                Single line consisting of a string S.
                Output Format
                Print total number of subsequences.
                Example 1
                Input

                abbcc
                Output
                9
                */
public class CountSubsequencesOfType_abc {
    public static int fun(String s)
    {
        long ewa = 0;   // count of string ended with a
        long ewb = 0;    // count of string ended with b
        long ewc = 0;    // count of string ended with c

        long mod=(long)1e9+7;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                ewa = 2*ewa + 1;
            } else if(s.charAt(i)=='b'){
                ewb = 2*ewb + ewa;
            } else if(s.charAt(i)=='c'){
                ewc = 2*ewc + ewb;
            }

            ewa = ewa%mod;
            ewb = ewb%mod;
            ewc = ewc%mod;
        }

        return (int)(ewc%mod);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        String s = sc.next() ;
        System.out.print(fun(s));

    }
}
