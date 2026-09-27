class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        int left=0;
        int right=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        for(int j=0;j<nums.length;j++){
            right=total-left-nums[j];
            if(left==right){
                return j;
        }
        else{
            left+=nums[j];
        }
    }
    return -1;
}
}
