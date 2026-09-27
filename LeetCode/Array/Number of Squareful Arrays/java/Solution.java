class Solution {
    int ans = 0;
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        boolean[] visited = new boolean[A.length];
        dfs(A, new ArrayList<>(), visited);
        return ans;
    }
    
    private void dfs(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!path.isEmpty() && !isPerfectSquare(path.get(path.size() - 1), nums[i])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    
    private boolean isPerfectSquare(int prev, int current) {
        double sqrt = Math.sqrt(prev + current);
        return (sqrt - Math.floor(sqrt)) == 0;
    }
}