1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        List<Integer> res = new ArrayList<>();
4
5        for (int n : nums) {
6            if (res.isEmpty() || res.get(res.size() - 1) < n) {
7                res.add(n);
8            } else {
9                int idx = binarySearch(res, n);
10                res.set(idx, n);
11            }
12        }
13
14        return res.size();        
15    }
16
17    private int binarySearch(List<Integer> arr, int target) {
18        int left = 0;
19        int right = arr.size() - 1;
20
21        while (left <= right) {
22            int mid = (left + right) / 2;
23            if (arr.get(mid) == target) {
24                return mid;
25            } else if (arr.get(mid) > target) {
26                right = mid - 1;
27            } else {
28                left = mid + 1;
29            }
30        }
31
32        return left;
33    }    
34}