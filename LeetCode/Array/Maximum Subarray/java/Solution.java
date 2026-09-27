class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int cu=0;
        for(int i=0;i<nums.length;i++){
            cu+=nums[i];
            if(cu>max){
                max=cu;
            }
            if(cu<0){
                cu=0;
            }
        }
        return max;
    }
}