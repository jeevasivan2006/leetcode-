class CountIntervals {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int sum = 0;
    public void add(int left, int right) {
        Integer leftIntervalStart = map.floorKey(left);
        Integer rightIntervalStart = map.ceilingKey(left);
        if (leftIntervalStart != null) {
            int leftIntervalEnd = map.get(leftIntervalStart);
            if (leftIntervalEnd >= left) {
                int preLen = leftIntervalEnd - leftIntervalStart + 1;
                sum = sum - preLen;
                map.remove(leftIntervalStart);
                left = Math.min(leftIntervalStart, left);
                right = Math.max(right, leftIntervalEnd);
            }
        }
        while (map.ceilingKey(left) != null && map.ceilingKey(left) <= right) {
            int nextIntervalStart = map.ceilingKey(left);
            int nextIntervalEnd = map.get(nextIntervalStart);
            right = Math.max(nextIntervalEnd, right);
            left = Math.min(nextIntervalStart, left);
            sum = sum - (nextIntervalEnd - nextIntervalStart + 1);
            map.remove(nextIntervalStart);
        }
        map.put(left, right);
        sum += (right - left + 1);
    }
    public int count() {
        return sum;
    }
}