class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[]arr=new int[n];
        int i=0;
        for(int val:nums){                     
            if(val<pivot){
                arr[i++]=val;
            }
        }
        for(int val:nums){
            if(val==pivot){
                arr[i++]=val;
            }
        }
        for(int val:nums){
            if(val>pivot){
                arr[i++]=val;
            }
        }
        return arr;
    }
}