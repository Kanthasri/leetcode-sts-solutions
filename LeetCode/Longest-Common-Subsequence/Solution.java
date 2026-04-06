1class Solution {
2        public int longestCommonSubsequence(String text1, String text2) {
3        int m = text1.length(), n = text2.length();
4        if (m < n) {
5            return longestCommonSubsequence(text2, text1);
6        }
7        int[] dp = new int[n + 1];
8        for (int i = 0; i < text1.length(); ++i) {
9            for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < text2.length(); ++j) {
10                prevRowPrevCol = prevRow;
11                prevRow = dp[j + 1];
12                dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? prevRowPrevCol + 1 : Math.max(dp[j], prevRow);
13            }
14        }
15        return dp[n];
16    }
17}