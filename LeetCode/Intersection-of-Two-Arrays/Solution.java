class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        set1 = set(nums1)
        ans = []
        for i in nums2:
            if i in set1:
                ans.append(i)
                set1.remove(i)
        return ans