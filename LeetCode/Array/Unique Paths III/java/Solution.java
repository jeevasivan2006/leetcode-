class Solution {
    public int uniquePathsIII(int[][] grid) {
        int sum = 0;
        int[] st = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != -1){
                    sum++;
                }
                if(grid[i][j] == 1){
                    st[0] = i;
                    st[1] = j;
                }
            }
        }
        return solve(st[0], st[1], grid, 1, sum);
    }
     public int solve(int i, int j, int[][] grid, int count, int sum){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1){
            return 0;
        }
        if(grid[i][j] == 2){
            if(count == sum){
                return 1;
            }
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;
        int u = solve(i-1, j, grid, count+1, sum);
        int d = solve(i+1, j, grid, count+1, sum);
        int l = solve(i, j-1, grid, count+1, sum);
        int r = solve(i, j+1, grid, count+1, sum);
        grid[i][j] = temp;
        return u + d + l + r;
    }
}