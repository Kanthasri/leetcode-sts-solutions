1class MinStack {
2    Stack<Integer> st;
3    Stack<Integer> minStack;
4    public MinStack() {
5        st=new Stack<>();
6        minStack=new Stack<>();
7    }
8    
9    public void push(int val) {
10        st.push(val);
11        if(minStack.isEmpty())minStack.push(val);
12        else{
13            if(minStack.peek()>=val){
14                minStack.push(val);
15            }
16        }
17    }
18    
19    public void pop() {
20        int val=st.pop();
21        if(val==minStack.peek())minStack.pop();
22    }
23    
24    public int top() {
25        return st.peek();
26    }
27    
28    public int getMin() {
29        return minStack.peek();
30    }
31}
32
33/**
34 * Your MinStack object will be instantiated and called as such:
35 * MinStack obj = new MinStack();
36 * obj.push(val);
37 * obj.pop();
38 * int param_3 = obj.top();
39 * int param_4 = obj.getMin();
40 */