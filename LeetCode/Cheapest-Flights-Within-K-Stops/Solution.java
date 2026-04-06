1import java.util.*;
2
3class Solution {
4    class Pair {
5        int dest, price;
6        Pair(int d, int p) { dest = d; price = p; }
7    }
8
9    class State {
10        int node, cost, stops;
11        State(int n, int c, int s) { node = n; cost = c; stops = s; }
12    }
13
14    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
15        List<List<Pair>> graph = new ArrayList<>();
16        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
17        for (int[] f : flights) graph.get(f[0]).add(new Pair(f[1], f[2]));
18
19        int[] minCost = new int[n];
20        Arrays.fill(minCost, Integer.MAX_VALUE);
21        minCost[src] = 0;
22
23        Queue<State> q = new LinkedList<>();
24        q.offer(new State(src, 0, 0));
25
26        while (!q.isEmpty()) {
27            State cur = q.poll();
28            if (cur.stops > k) continue;
29
30            for (Pair next : graph.get(cur.node)) {
31                int newCost = cur.cost + next.price;
32                if (newCost < minCost[next.dest]) {
33                    minCost[next.dest] = newCost;
34                    q.offer(new State(next.dest, newCost, cur.stops + 1));
35                }
36            }
37        }
38        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
39    }
40}