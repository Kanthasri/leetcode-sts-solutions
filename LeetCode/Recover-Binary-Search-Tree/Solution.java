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
18    public void inorder(TreeNode root, ArrayList<TreeNode> list) {
19        if (root == null) return;
20
21        inorder(root.left, list);  
22        list.add(root);
23        inorder(root.right, list);
24    }
25
26    public void recoverTree(TreeNode root) {
27        ArrayList<TreeNode> list = new ArrayList<>();
28        inorder(root, list);
29
30        TreeNode first = null;
31        TreeNode second = null;
32
33        for (int i = 0; i < list.size() - 1; i++) {
34            if (list.get(i).val > list.get(i + 1).val) {
35
36                if (first == null) {
37                    first = list.get(i);
38                }
39
40                second = list.get(i + 1);
41            }
42        }
43
44        // swap values
45        int temp = first.val;
46        first.val = second.val;
47        second.val = temp;
48    }
49}