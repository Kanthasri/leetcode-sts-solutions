class KthLargest {
    int k;
    PriorityQueue<Integer> kLargest = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if (kLargest.size() < k) {
            kLargest.offer(val);
        } else if (kLargest.peek() < val) {
            kLargest.poll();
            kLargest.offer(val);
        }
        
        return kLargest.peek();
    }
}