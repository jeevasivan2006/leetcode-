class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        sub(0,nums,ans,new ArrayList<>());
            return ans;
        }
        public static void sub(int index,int nums[], List<List<Integer>> ans,List<Integer> temp){
            ans.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            sub(i + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}