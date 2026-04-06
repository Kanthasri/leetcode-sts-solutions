1class Solution {
2      public class  Pair implements Comparable<Pair>{
3         int node;
4         int time;
5         Pair(int node, int time){
6            this.node = node;
7             this.time = time;
8         }
9         public int compareTo(Pair p){
10            if(this.time==p.time)  return this.node - p.node;
11            return this.time -  p.time;
12         }
13    }
14    public int networkDelayTime(int[][] times, int n, int src) {
15        ArrayList<ArrayList<Pair>>adj =  new ArrayList<>();
16        for(int i = 0;i<=n;i++){
17        adj.add(new ArrayList<Pair>());
18        }
19        for(int i =0;i<times.length;i++){
20          int u =  times[i][0];
21           int v =  times[i][1];
22           int time =  times[i][2];
23        adj.get(u).add(new Pair(v,time));
24        }
25        int []ans =  new int[n+1];
26        Arrays.fill(ans,Integer.MAX_VALUE);
27        ans[src]=0;
28        PriorityQueue<Pair>pq  =  new PriorityQueue<>();
29        pq.add(new Pair(src,0));
30        while(pq.size()>0){
31        Pair top = pq.remove();
32        int node =  top.node;
33        int time =  top.time;
34       if(top.time>ans[node]) continue;
35        for(Pair p:adj.get(node)){
36            int totalTime = top.time+ p.time;
37        if(totalTime<ans[p.node]){
38            ans[p.node]=totalTime;
39            pq.add(new Pair(p.node,totalTime));
40            }
41          }
42        }
43        int max = -1;
44        for(int i = 1;i<=n;i++){
45            if(ans[i]==Integer.MAX_VALUE) return -1;
46            max =  Math.max(max,ans[i]);
47        }
48   return max;
49    }
50}