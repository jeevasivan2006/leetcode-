class Solution {
    //memo
    public boolean canCross(int[] stones) {
        if(stones.length==1) return true;
        Map<Integer,Integer> map = new HashMap<>();
        int n = stones.length;
        for(int i = 0; i < n ; i++) map.put(stones[i], i);
        Boolean [][]memo = new Boolean[n][n+1];
        return check(stones ,map, 0, 0, memo) ;
    }
    public boolean check(int stones[], Map<Integer,Integer> map, int idx, int jump, Boolean[][]memo){
        if(idx == stones.length-1) return true;
        else if(memo[idx][jump]!=null) return memo[idx][jump];
        else{
            int pos = stones[idx] ;
            for(int nj = jump-1; nj<=jump+1; nj++){
                if(nj<=0) continue;
                int nextPos = pos+nj;
                if(map.containsKey(nextPos)){
                    if(check(stones, map, map.get(nextPos), nj, memo)) return memo[idx][jump] = true;
                }
            }
            return memo[idx][jump] = false;

        }
    }
}