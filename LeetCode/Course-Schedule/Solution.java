1import java.util.*;
2
3public class Solution {
4
5    public boolean canFinish(int numCourses, int[][] prerequisites) {
6
7        // Create adjacency list
8        List<List<Integer>> adj = new ArrayList<>();
9        for (int i = 0; i < numCourses; i++) {
10            adj.add(new ArrayList<>());
11        }
12
13        // Build graph
14        for (int[] pre : prerequisites) {
15            adj.get(pre[1]).add(pre[0]);
16        }
17
18        boolean[] vis = new boolean[numCourses];   // visited
19        boolean[] path = new boolean[numCourses];  // recursion stack
20
21        // Check each course
22        for (int i = 0; i < numCourses; i++) {
23            if (!vis[i] && dfs(i, adj, vis, path)) {
24                return false;   // cycle found
25            }
26        }
27
28        return true;   // no cycle
29    }
30
31    // DFS to detect cycle
32    private boolean dfs(int node, List<List<Integer>> adj,
33                        boolean[] vis, boolean[] path) {
34
35        vis[node] = true;
36        path[node] = true;
37
38        for (int next : adj.get(node)) {
39
40            // If not visited, explore
41            if (!vis[next]) {
42                if (dfs(next, adj, vis, path)) {
43                    return true;
44                }
45            }
46            // If already in current recursion path → cycle
47            else if (path[next]) {
48                return true;
49            }
50        }
51
52        // Remove from current path
53        path[node] = false;
54        return false;
55    }
56
57    // MAIN METHOD
58    public static void main(String[] args) {
59
60        Solution sol = new Solution();
61
62        // Example 1
63        int numCourses1 = 2;
64        int[][] prerequisites1 = {{1, 0}};
65        System.out.println("Can finish (Example 1): "
66                + sol.canFinish(numCourses1, prerequisites1));
67
68        // Example 2 (cycle exists)
69        int numCourses2 = 2;
70        int[][] prerequisites2 = {{1, 0}, {0, 1}};
71        System.out.println("Can finish (Example 2): "
72                + sol.canFinish(numCourses2, prerequisites2));
73    }
74}