1class StockSpanner {
2    Stack<int[]> st;
3    public StockSpanner() {
4        st=new Stack<>();
5    }
6    
7    public int next(int price) {
8        int span=1;
9
10        while(!st.isEmpty() && st.peek()[0]<=price){
11            span+=st.peek()[1];
12            st.pop();
13        }
14        st.push(new int[]{price,span});
15
16        return span;
17    }
18}
19/**
20 * Your StockSpanner object will be instantiated and called as such:
21 * StockSpanner obj = new StockSpanner();
22 * int param_1 = obj.next(price);
23 */