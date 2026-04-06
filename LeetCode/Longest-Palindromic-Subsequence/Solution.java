1class Solution {
2    public int longestPalindromeSubseq(String s) {
3        // Reverse the original string
4        String rev = new StringBuilder(s).reverse().toString();
5        
6        char[] str1 = s.toCharArray();
7        char[] str2 = rev.toCharArray();
8        int n = str1.length;
9
10        // DP table for LCS
11        int[][] dp = new int[n + 1][n + 1];
12
13        for (int i = 1; i <= n; i++) {
14            for (int j = 1; j <= n; j++) {
15                if (str1[i - 1] == str2[j - 1]) {
16                    // Characters match
17                    dp[i][j] = dp[i - 1][j - 1] + 1;
18                } else {
19                    // Mismatch: take max of excluding one char from either string
20                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
21                }
22            }
23        }
24        return dp[n][n];
25    }
26}