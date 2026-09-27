class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int pcount=0;
        int ncount=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                 ncount++;
            }
            else if(nums[i]>0){
                pcount++;
            }
        }
        if(ncount>pcount){
            return ncount;
        }
        return pcount;
    }
}