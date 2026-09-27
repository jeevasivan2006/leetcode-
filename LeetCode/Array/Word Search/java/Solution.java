// class Solution {
//     public boolean exist(char[][] board, String w) {
//         //StringBuilder sb=new StringBuilder();
//         int i=0;
//         char f[]=new char[w.length()];
//         for(int k=0;k<board.length;k++){
//             for(int j=0;j<board.length;j++){
//                 char ch=w.charAt(i);
//                 if(ch==board[k][j]){
//                     f[i]=board[k][j];
//                     i++;
//                 }
//                 }
//             }
//             if(i!=w.length()){
//                  return false;
//                 }   // break;
//         for(int k=0;k<w.length();k++){
//             if(f[i]!=w.charAt(i)){
//                 return false;
//                // break;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    
    public boolean exist(char[][] board, String word) {
    int row;
    int col;
    row=board.length;
    col=board[0].length;
    for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
    if(board[i][j]==word.charAt(0) && backtrack(board,word,0,i,j,row,col)){
                return true;
        }
      }
    }
        return false;
    }

    private boolean backtrack(char [][] board,String word,int i,int r,int c,int row,int col){
        if(r<0||c<0||r>=row||c>=col||board[r][c]!=word.charAt(i)) {
        return false;
        }

        if (i == word.length() - 1) {
        return true;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found =
        backtrack(board, word, i + 1, r - 1, c,row,col) ||
        backtrack(board, word, i + 1, r + 1, c,row,col) ||
        backtrack(board, word, i + 1, r, c - 1,row,col) ||
        backtrack(board, word, i + 1, r, c + 1,row,col);

        board[r][c] = temp;

        return found; 
    }
}