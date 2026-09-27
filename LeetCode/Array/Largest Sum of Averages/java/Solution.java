class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] p = new double[n+1];
        for(int i=0;i<n;i++){
            p[i+1] = p[i] + nums[i];
        }
        double[] dp = new double[n];
        for(int i=0;i<n;i++){
            dp[i] = (p[n]-p[i])/(n-i);
        }
        for(int K=0;K<k-1;K++){
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    dp[i] = Math.max(dp[i],(p[j]-p[i])/(j-i)+dp[j]);
                }
            }
        }
        return dp[0];
    }
}