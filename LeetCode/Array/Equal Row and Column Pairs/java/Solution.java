class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<grid.length;j++){
                sb.append(grid[i][j]).append(".");
            }
            map.put(sb.toString() ,map.getOrDefault(sb.toString(),0)+1);
        }
        for(int i=0;i<grid.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<grid.length;j++){
                sb.append(grid[j][i]).append(".");
            }
            count+=map.getOrDefault(sb.toString(),0);
        }
        return count;
    }
}