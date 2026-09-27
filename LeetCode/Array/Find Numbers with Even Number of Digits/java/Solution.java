class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int digit=0;
            while(nums[i]>0){
                digit++;
                nums[i]/=10;
            }
            if(digit%2==0){
                count++;
                } 
        }
        return count;
    }
}