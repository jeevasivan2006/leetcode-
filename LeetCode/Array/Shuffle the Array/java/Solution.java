class Solution {
    public int[] shuffle(int[] nums, int n) {
         List<Integer> list=new ArrayList<>();
         for(int i=0;i<n;i++){
           list.add(nums[i]);
           list.add(nums[i+n]);
    }
    int ind=0;
    for(int val:list) nums[ind++]=val;
          return nums;
    }
}