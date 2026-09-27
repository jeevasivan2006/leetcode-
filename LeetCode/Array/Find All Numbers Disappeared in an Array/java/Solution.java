class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        /*int n=nums.length;
        int count=0;
        for(int i=1;i<=n;i++){
            count=0;
            for(int j=0;j<n;j++)  if(i==nums[j]) count++;
            if(count==0) 
                list.add(i); 
        }return list;this code is only 32 pass*/
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]=-nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}