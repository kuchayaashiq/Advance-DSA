package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class WordBreak_Leetcode {
    public static void recr(String s, int idx, boolean[] dp,
                            List<String> ans, String curr, HashSet<String> hs) {
        if(idx == s.length()){
            ans.add(curr);
            return;
        }
        for(int i = idx; i <= s.length(); i++){
            if(dp[idx] && hs.contains(s.substring(idx, i))){
                dp[i] = true;
                String str = curr;
                curr += s.substring(idx, i);
                if(i != s.length()){
                    curr +=" ";
                }
                recr(s, i, dp, ans, curr, hs);
                curr = str;
            }
        }

    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(String str : wordDict){
            hs.add(str);
        }
        List<String> ans = new ArrayList<>();
        recr(s, 0, dp, ans, "", hs);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> wordDict = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wordDict.add(sc.next());
        }
        String s = sc.next();
        List<String> result = wordBreak(s, wordDict);
        System.out.println(result);
    }
}
