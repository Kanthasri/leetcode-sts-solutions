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
16 class Solution {
17
18    public List<Integer> rightSideView(TreeNode root) {
19        List<Integer> result = new ArrayList<>();
20        if (root == null) return result;
21
22        Queue<TreeNode> queue = new LinkedList<>();
23        queue.offer(root);
24
25        while (!queue.isEmpty()) {
26            int size = queue.size();
27
28            for (int i = 0; i < size; i++) {
29                TreeNode node = queue.poll();
30
31                if (i == size - 1) {
32                    result.add(node.val);
33                }
34
35                if (node.left != null)
36                    queue.offer(node.left);
37                if (node.right != null)
38                    queue.offer(node.right);
39            }
40        }
41        return result;
42    }
43}
44
45// Testing
46public class Main {
47    public static void main(String[] args) {
48
49        // Build sample tree:
50        //        1
51        //       / \
52        //      2   3
53        //       \   \
54        //        5   4
55
56        TreeNode root = new TreeNode(1);
57        root.left = new TreeNode(2);
58        root.right = new TreeNode(3);
59        root.left.right = new TreeNode(5);
60        root.right.right = new TreeNode(4);
61
62        Solution sol = new Solution();
63        System.out.println(sol.rightSideView(root));
64    }
65}
66