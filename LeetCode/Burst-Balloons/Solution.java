1// Using Tabulation (Bottom-Up DP):
2class Solution {
3    public int maxCoins(int[] nums) {
4        int n = nums.length;
5        int[] newNums = new int[n + 2];
6        newNums[0] = 1;
7        newNums[n + 1] = 1;
8
9        int[][] dp = new int[n + 2][n + 2];
10
11        for (int i = 0; i < n; i++) newNums[i + 1] = nums[i];
12
13        // i = left boundary of current interval, iterate from right to left
14        // so that smaller subproblems (dp[i][k-1], dp[k+1][j]) are already filled
15        for (int i = n; i >= 1; i--) {
16            for (int j = 1; j <= n; j++) {
17                if (i > j) continue;
18                int max = Integer.MIN_VALUE;
19
20                // k = the LAST balloon burst in range [i, j]
21                for (int k = i; k <= j; k++) {
22                    int cost = newNums[i - 1] * newNums[k] * newNums[j + 1]
23                             + dp[i][k - 1]
24                             + dp[k + 1][j];
25                    max = Math.max(max, cost);
26                }
27                dp[i][j] = max;
28            }
29        }
30
31        return dp[1][n];
32    }
33}
34
35
36 
37