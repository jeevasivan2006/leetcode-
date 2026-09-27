class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length,start=0,end=nums.length-1;
        int[] result=new int[nums.length];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
            result[start++]=nums[i];
             }
            else if(nums[i]%2!=0){
             result[end--]=nums[i];
            }
        }
        return result;
    }
}