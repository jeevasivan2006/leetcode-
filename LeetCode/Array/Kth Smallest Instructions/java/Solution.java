class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int h = destination[1];
        int v = destination[0];
        StringBuilder sb = new StringBuilder();
        while (h > 0 && v > 0) {
            long c = comb(h + v - 1, h -1);
            if (k > c) {
                sb.append("V");
                v--;
                k-=c;
            } else {
                sb.append("H");
                h--;
            }
        }
        while (h > 0) {
            sb.append("H");
            h--;
        }
        while (v > 0) {
            sb.append("V");
            v--;
        }
        return sb.toString();
    }

    private long comb(int m, int n) {
        long com = 1;
        for (long i = m - n + 1; i <= m; i++) com*=i;
        for (long i = 1; i <= n; i++) com/=i;
        return com;
    }
}