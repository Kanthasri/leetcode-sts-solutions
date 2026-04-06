1class MedianFinder {
2    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
3    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
4    
5    public MedianFinder() {
6    }
7    public void addNum(int num) {
8        maxHeap.offer(num);
9        minHeap.offer(maxHeap.poll());
10        if (minHeap.size() > maxHeap.size())
11            maxHeap.offer(minHeap.poll());
12    }
13    public double findMedian() {
14        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
15        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
16    }
17}
18/**
19 * Your MedianFinder object will be instantiated and called as such:
20 * MedianFinder obj = new MedianFinder();
21 * obj.addNum(num);
22 * double param_2 = obj.findMedian();
23 */