1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    private void helper(TreeNode root,
19        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map,
20        int c, int r) {
21
22        if (root == null) return;
23
24        map.putIfAbsent(c, new TreeMap<>());
25        map.get(c).putIfAbsent(r, new PriorityQueue<>());
26        map.get(c).get(r).offer(root.val);
27
28        helper(root.left, map, c - 1, r + 1);
29        helper(root.right, map, c + 1, r + 1);
30    }
31
32    public List<List<Integer>> verticalTraversal(TreeNode root) {
33        List<List<Integer>> res = new ArrayList<>();
34        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
35
36        helper(root, map, 0, 0);
37
38        for (Map<Integer, PriorityQueue<Integer>> cols : map.values()) {
39            List<Integer> colList = new ArrayList<>();
40
41            for (PriorityQueue<Integer> pq : cols.values()) {
42                while (!pq.isEmpty()) {
43                    colList.add(pq.poll());
44                }
45            }
46
47            res.add(colList);
48        }
49
50        return res;
51    }
52}