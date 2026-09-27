class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'.');
        }
        boolean rows[]=new boolean[n];
        boolean left[]=new boolean[2*n-1];
        boolean right[]=new boolean[2*n-1];
        solve(0,board,rows,left,right,ans,n);
        return ans;
    }
    public void solve(int col,char[][] board,boolean rows[],boolean[] left,boolean[] right,List<List<String>> ans,int n){
        if(col==n){
            ArrayList<String> temp=new ArrayList<>();
            for(char ch[]:board){
                StringBuilder sb=new StringBuilder();
                for(char c:ch){
                    sb.append(c);
                }
                temp.add(sb.toString());
               
            }
            ans.add(new ArrayList<>(temp));
             return;
        }
            for(int row=0;row<n;row++){
                int d1=row+col;
            int d2=row-col+n-1;
            if(rows[row]||left[d1]||right[d2]) continue;
            board[row][col]='Q';
            rows[row]=true;
            left[d1]=true;
            right[d2]=true;
            solve(col+1,board,rows,left,right,ans,n);
             board[row][col]='.';
            rows[row]=false;
            left[d1]=false;
            right[d2]=false;
        }
    }
}