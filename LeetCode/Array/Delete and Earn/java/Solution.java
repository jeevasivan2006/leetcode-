class Solution 
{
    public int deleteAndEarn(int[] nums)
    {
        // O(N + k) time where N is the length of nums[ ] and k is the max element in nums[ ] so length of two for-loop
        // O(N + k) space
        if(nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        
        int maxNumber = Integer.MIN_VALUE;
        HashMap<Integer, Integer> points = new HashMap<>();

        // update map
        for(int num : nums)
        {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        
        // maxNumber+1 because we need to save the result of maxSum[maxNumber] for the maxNumber
        int[] maxSum = new int[maxNumber + 1];
        maxSum[0] = 0;
        maxSum[1] = points.getOrDefault(1, 0);
        
        for(int i = 2; i < maxSum.length; i++)
        {
            int gain = points.getOrDefault(i, 0);
            maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2] + gain);
        }
        return maxSum[maxSum.length-1];
    }
}