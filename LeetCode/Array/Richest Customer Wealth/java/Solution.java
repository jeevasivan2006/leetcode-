class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int i=0;i<accounts.length;i++){
            int c=0;
            for(int j=0;j<accounts[i].length;j++){
                c+=accounts[i][j];
            }
            if(max<c){
                max=c;
            }
        }
        return max;
    }
}