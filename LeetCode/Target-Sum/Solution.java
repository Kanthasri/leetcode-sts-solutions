class Solution {
    int ways = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,0,target);
        return ways;
    }
    void dfs(int []arr,int idx,int sum,int tar){
        if(idx==arr.length){
            if(sum==tar){
                ways++;
            }
            return;
        }
        dfs(arr,idx+1,sum+arr[idx],tar);
        dfs(arr,idx+1,sum-arr[idx],tar);
    }
}
