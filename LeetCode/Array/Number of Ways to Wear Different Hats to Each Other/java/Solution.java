class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer>[] people = new ArrayList[41];
        for(int i = 0;i <= 40;i++) people[i]= new ArrayList<>();
        for(int p = 0;p < n;p++){
            for(int h : hats.get(p)){
                people[h].add(p);
            }
        }
        long mod = (long)1e9+7;
        long[] dp = new long[(1 << n)];
        dp[(1 << n) - 1] = 1L;
        for(int h = 1;h <= 40;h++){
            long[] currDp = dp.clone();
            for(int mask = (1 << n)-1;mask >= 0;mask--){
                for(int p : people[h]){
                    if((mask & (1 << p)) == 0){
                        currDp[mask] = (currDp[mask]%mod + dp[(mask | (1 << p))]%mod)%mod;
                    }
                }
            }
            dp = currDp;
        }
        return (int)dp[0];
    }
}