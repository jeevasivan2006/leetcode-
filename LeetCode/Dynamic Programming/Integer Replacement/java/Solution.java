class Solution {
    public int integerReplacement(int n) {
        HashMap<Long,Long>map = new HashMap<>();
        return (int)helper(n,map);
    }

    public long helper(long n,HashMap<Long,Long>map){
        if(n==1){
            return 0;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n%2==0){
            long ans=1 + helper(n/2,map);
            map.put(n,ans);
            return ans;
        }
        else{
            long op1 = helper(n-1,map);
            long op2 = helper(n+1,map);
            long ans=Math.min(op1,op2)+1;
            map.put(n,ans);
            return ans;
        }
    }
}