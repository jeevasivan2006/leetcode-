class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit=new boolean[nums.length];
        permute(nums,visit,list,new ArrayList());
        return list;
    }
    public static void permute(int nums[],boolean[] visit,List<List<Integer>> list,List<Integer> temp){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {

            if(visit[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !visit[i-1]) {
                continue;
            }
            visit[i] = true;
            temp.add(nums[i]);
            permute(nums, visit, list, temp);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
        }
    }
