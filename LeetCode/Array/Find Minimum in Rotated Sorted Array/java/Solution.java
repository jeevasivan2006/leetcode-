class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1; //low and high
        int res=nums[l+(h-l)/2]; //result we assumed the samllest to be mid element
        while(l<=h){ //normal condition to break out
            int m=l+(h-l)/2; //middle 
            //left is sorted
            if(nums[l]<=nums[m]){
                res=Math.min(nums[l],res); //store the leftmost element
                //but check right half
                l=m+1; //move pinter left to mid + 1
            }
            // right is sorted
            else{
                res=Math.min(res,nums[m]); // so store the min between the res and mid elemnt
                //but check left half
                h=m-1; // move pointer high to mid -1
            }
        }
        return res; // return the answer
    }
}