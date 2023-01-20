package DynamicProgramming.StringDP;

import java.util.Arrays;

public class WildCardCharacters {
    public boolean wildCard_rec(int n, int m, String s, String p){
        if(n==0 || m==0){
            if(n==0 && m==0){
                return true;
            } else if(m==1 && p.charAt(m-1)=='*'){
                return true;
            } else {
                return false;
            }
        }

        if(p.charAt(m-1)=='?'){
            return wildCard_rec(n-1, m-1, s, p);
        } else if(p.charAt(m-1)=='*'){
            return wildCard_rec(n-1, m, s, p) || wildCard_rec(n, m-1, s, p);
        } else if(s.charAt(n-1) == p.charAt(m-1)){
            return wildCard_rec(n-1, m-1, s, p);
        } else {
            return false;
        }
    }

    public int wildCard_memo(int n, int m, String s, String p,int[][] dp){
        if(n==0 || m==0){
            if(n==0 && m==0){
                return dp[n][m] = 1;
            } else if(m==1 && p.charAt(m-1)=='*'){
                return dp[n][m] = 1;
            } else {
                return dp[n][m] = 0;
            }
        }

        if(dp[n][m]!=-1) return dp[n][m];

        if(p.charAt(m-1)=='?'){
            return dp[n][m] = wildCard_memo(n-1, m-1, s, p,dp);
        } else if(p.charAt(m-1)=='*'){
            return dp[n][m] = wildCard_memo(n-1, m, s, p,dp) | wildCard_memo(n, m-1, s, p,dp);
        } else if(s.charAt(n-1) == p.charAt(m-1)){
            return dp[n][m] = wildCard_memo(n-1, m-1, s, p,dp);
        } else {
            return dp[n][m] = 0;
        }
    }

    public int wildCard_tab(int N, int M, String s, String p, int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    if(n==0 && m==0){
                        dp[n][m] = 1;
                    } else if(m==1 && p.charAt(m-1)=='*'){
                        dp[n][m] = 1;
                    } else {
                        dp[n][m] = 0;
                    }
                    continue;
                }

                if(p.charAt(m-1)=='?'){
                    dp[n][m] = dp[n-1][m-1]; //wildCard_memo(n-1, m-1, s, p,dp);
                } else if(p.charAt(m-1)=='*'){
                    dp[n][m] = dp[n-1][m] | dp[n][m-1]; //wildCard_memo(n-1, m, s, p,dp) | wildCard_memo(n, m-1, s, p,dp);
                } else if(s.charAt(n-1) == p.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1]; //wildCard_memo(n-1, m-1, s, p,dp);
                } else {
                    dp[n][m] = 0;
                }
            }
        }

        return dp[N][M];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];

        for(int[] d:dp){
            Arrays.fill(d,-1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m;){
            if(p.charAt(i)=='*'){
                sb.append("*");
                while(i<m && p.charAt(i)=='*') i++;
            } else {
                sb.append(p.charAt(i));
                i++;
            }
        }

        p=sb.toString();
        m=p.length();

        return wildCard_tab(n, m, s, p, dp) == 1 ? true : false;
        // return wildCard_memo(n,m,s,p,dp) == 1 ? true : false;
        // return wildCard_rec(n,m,s,p);
    }
}
