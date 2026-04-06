1import java.util.*;
2
3class Solution {
4
5    public int numIslands(char[][] grid) {
6
7        if (grid == null || grid.length == 0)
8            return 0;
9
10        int m = grid.length;
11        int n = grid[0].length;
12        int count = 0;
13
14        for (int i = 0; i < m; i++) {
15            for (int j = 0; j < n; j++) {
16
17                if (grid[i][j] == '1') {
18                    count++;
19                    dfs(grid, i, j);
20                }
21            }
22        }
23
24        return count;
25    }
26
27    private void dfs(char[][] grid, int i, int j) {
28
29        int m = grid.length;
30        int n = grid[0].length;
31
32        // Boundary check + water check
33        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
34            return;
35
36        grid[i][j] = '0'; // mark visited
37
38        // Visit 4 directions
39        dfs(grid, i + 1, j);
40        dfs(grid, i - 1, j);
41        dfs(grid, i, j + 1);
42        dfs(grid, i, j - 1);
43    }
44}
45
46public class Main {
47    public static void main(String[] args) {
48
49        char[][] grid = {
50                {'1','1','0','0','0'},
51                {'1','1','0','0','0'},
52                {'0','0','1','0','0'},
53                {'0','0','0','1','1'}
54        };
55
56        Solution sol = new Solution();
57        int result = sol.numIslands(grid);
58
59        System.out.println("Number of Islands: " + result);
60    }
61}