class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visit=new boolean[nums.length];
        permutation(nums,visit,list,new ArrayList());
        return list;
    }
    public void permutation(int nums[],boolean []visit,List<List<Integer>> list,List<Integer> temp){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                visit[i]=true;
                temp.add(nums[i]);
                permutation(nums,visit,list,temp);
                temp.remove(temp.size()-1);
                visit[i]=false;
            }
        }
    }
}