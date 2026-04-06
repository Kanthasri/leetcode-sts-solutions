1class Solution {
2    public boolean canPartition(int[] nums) {
3        int totalSum = 0;
4        for (int num : nums) totalSum += num;
5        if (totalSum % 2 != 0) return false;
6        int targetSum = totalSum / 2;
7        boolean[] dp = new boolean[targetSum + 1];
8        dp[0] = true;
9        for (int num : nums) {
10            for (int currSum = targetSum; currSum >= num; currSum--) {
11                dp[currSum] = dp[currSum] || dp[currSum - num];
12                if (dp[targetSum]) return true;
13            }
14        }
15        return dp[targetSum];
16    }
17}