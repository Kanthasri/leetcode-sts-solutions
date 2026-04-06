1class Solution {
2    public boolean validateStackSequences(int[] pushed, int[] popped) {
3    
4        Stack<Integer> stack = new Stack<>();
5        int j = 0;
6
7        for(int i = 0; i < pushed.length; i++) {
8            stack.push(pushed[i]);
9            while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
10                stack.pop();
11                j++;
12            }
13        }
14
15        return j == popped.length;
16    }
17}