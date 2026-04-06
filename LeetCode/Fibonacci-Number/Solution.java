1
2class Solution {
3    public int fib(int n) {
4        if (n <= 1) return n;
5
6        int prev2 = 0; // F(0)
7        int prev1 = 1; // F(1)
8
9        for (int i = 2; i <= n; i++) {
10            int curr = prev1 + prev2;
11            prev2 = prev1;
12            prev1 = curr;
13        }
14
15        return prev1;
16    }
17}
18
19