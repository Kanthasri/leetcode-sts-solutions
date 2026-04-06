1class Solution {
2    public void sortColors(int[] nums) {
3        int low = 0, mid = 0, high = nums.length - 1;
4        while (mid <= high) {
5            if (nums[mid] == 0) {
6                swap(nums, low, mid);
7                low++;
8                mid++;
9            } else if (nums[mid] == 1) {
10                mid++;
11            } else {
12                swap(nums, mid, high);
13                high--;
14            }
15        }
16    }
17    
18    private void swap(int[] nums, int i, int j) {
19        int temp = nums[i];
20        nums[i] = nums[j];
21        nums[j] = temp;
22    }
23}