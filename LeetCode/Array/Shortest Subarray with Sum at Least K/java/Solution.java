// class Solution {
//     public int shortestSubarray(int[] nums, int k) {
//         List<List<Integer>> jeeva=new ArrayList<>();
//         jeeva.add(new ArrayList());
//         int sum=0;
//         int size=0;
//         int o=0;
//         int min=nums.length;
//         int arr[]=new int[o];
//         StringBuilder sb=new StringBuilder();
//         for(int a:nums){
//             int c=jeeva.size();
            
//             for(int i=0;i<c;i++){
//             List<Integer> jee=new ArrayList<>(jeeva.get(i));
//             sum+=a;
//             arr[min]=a;
//             o++;
//             if(sum==k){
//                for(int r: arr){
//                 jee.add(r);
//                }
//                Arrays.fill(arr,0);
//                o=0;
//                min=Math.min(min,jee.size());
//             }}
//         }
//         return min;
//     }
// }


class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int shortestSubarrayLength = Integer.MAX_VALUE;
        long cumulativeSum = 0;
        PriorityQueue<Pair<Long, Integer>> prefixSumHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getKey(), b.getKey()));
        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            if (cumulativeSum >= k) {
                shortestSubarrayLength = Math.min(shortestSubarrayLength,i + 1);
            }
            while (!prefixSumHeap.isEmpty() && cumulativeSum - prefixSumHeap.peek().getKey() >= k)
             {
                shortestSubarrayLength = Math.min(shortestSubarrayLength, i - prefixSumHeap.poll().getValue());
            }
            prefixSumHeap.offer(new Pair<>(cumulativeSum, i));
        }
        return shortestSubarrayLength == Integer.MAX_VALUE ? -1: shortestSubarrayLength;
    }
}