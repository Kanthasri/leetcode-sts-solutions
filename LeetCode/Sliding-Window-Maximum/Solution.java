1class Solution {
2    public int[] maxSlidingWindow(int[] n, int k) {
3      Deque<Integer> d = new ArrayDeque<>();
4        ArrayList<Integer> a= new ArrayList<>();
5        
6
7        //put elements and maintian decrease order like from front to back in queue
8        
9        for(int i=0; i<n.length; i++){
10
11            //to maintian k window
12            if(!d.isEmpty() && d.peekFirst()<=i-k) d.removeFirst();
13            while(!d.isEmpty() && n[i]>=n[d.peekLast()] ){
14                d.removeLast();
15            }
16            //add index
17            d.addLast(i);
18
19            //add index of stack form first if window is of k size
20          if(i>=k-1)   a.add(n[d.getFirst()]);
21        }
22
23        
24       int ans[]= new int[a.size()];
25       for(int i=0; i<a.size(); i++){
26        ans[i]=a.get(i);
27       }
28       return ans;
29    }
30}