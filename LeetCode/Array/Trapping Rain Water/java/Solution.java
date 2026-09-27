class Solution {
    public int trap(int[] height) {
        int lMax=height[0],rMax=height[height.length-1], i=0, j=height.length-1;
        int trappedWater=0;
        while(i<=j){
            if(lMax<rMax){
                if(lMax>height[i]){
                    trappedWater+=lMax-height[i];
                }
                else{
                    lMax = height[i];
                }
                i++;
            }
            else{
                if(rMax>height[j]){
                    trappedWater+=rMax-height[j];
                }
                else{
                    rMax = height[j];
                }
                j--;
            }
            
        }
        return trappedWater;
    }
}