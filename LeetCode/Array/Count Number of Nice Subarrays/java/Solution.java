class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     nums[i]=nums[i]%2==0 ? 0:1;
        // }
        // int count =0;
        // int right=0;
        // int oddco=0;
        // int[] prefixcou=new int[n+1];
        // prefixcou[0]=1;
        // while(right<n){
        //     oddco+=nums[right];
        //     right++;
        //     if(oddco>=k){
        //         count+=prefixcou[oddco-k];
        //     }
        //     prefixcou[oddco]++;
        // }
        // return count;
        int prefixsum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i:nums){
            if(i%2!=0)
            prefixsum+=i%2;
            count+=map.getOrDefault(prefixsum-k,0);
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}