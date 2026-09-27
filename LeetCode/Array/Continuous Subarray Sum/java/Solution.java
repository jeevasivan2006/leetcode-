import java.util.HashMap;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            pre = (pre + nums[i]) % k;
            if (map.containsKey(pre)) {
                if (i - map.get(pre) > 1) {
                    return true;
                }
            } else {
                map.put(pre, i);
            }
        }
        return false;
    }
}
