1class Data {
2    String val;
3    int time;
4    Data(String val, int time) {
5        this.val = val;
6        this.time = time;
7    }
8}
9class TimeMap {
10
11    Map<String, List<Data>> map;
12    public TimeMap() {
13        map = new HashMap<String, List<Data>>();
14    }
15
16    public void set(String key, String value, int timestamp) {
17        map.computeIfAbsent(key, k -> new ArrayList<Data>()).add(new Data(value, timestamp));
18    }
19
20    public String get(String key, int timestamp) {
21        if (!map.containsKey(key)) return "";
22        return binarySearch(map.get(key), timestamp);
23    }
24
25    private String binarySearch(List<Data> list, int time) {
26        int left = 0, right = list.size() - 1;
27        while (left < right) {
28            int mid = (left + right + 1) >>> 1;
29            if (time < list.get(mid).time)
30                right = mid - 1;
31            else
32                left = mid;
33        }
34        return list.get(left).time <= time ? list.get(left).val : "";  // left == right
35    }
36}
37/**
38 * Your TimeMap object will be instantiated and called as such:
39 * TimeMap obj = new TimeMap();
40 * obj.set(key,value,timestamp);
41 * String param_2 = obj.get(key,timestamp);
42 */