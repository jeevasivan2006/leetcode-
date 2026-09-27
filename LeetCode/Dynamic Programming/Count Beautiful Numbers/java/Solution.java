class Solution {
    private Map<Integer, Integer>[][][] memo;
    
    @SuppressWarnings("unchecked")
    public int beautifulNumbers(int low, int high) {
        String upperBound = String.valueOf(high);
        String lowerBound = String.valueOf(low - 1);
        
        return countBeautiful(upperBound) - countBeautiful(lowerBound);
    }
    
    private int countBeautiful(String num) {
        int n = num.length();
        resetMemo(n);
        return calculate(0, true, 0, 1, num);
    }
    
    @SuppressWarnings("unchecked")
    private void resetMemo(int size) {
        memo = new HashMap[size][2][82];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 82; k++) {
                    memo[i][j][k] = new HashMap<>();
                }
            }
        }
    }
    
    private int calculate(int pos, boolean bounded, int digitSum, int digitProduct, String number) {
        if (pos == number.length()) {
            if (digitSum == 0) return 0;
            return (digitProduct % digitSum == 0) ? 1 : 0;
        }
        
        Map<Integer, Integer> currentMap = memo[pos][bounded ? 1 : 0][digitSum];
        if (currentMap.containsKey(digitProduct)) {
            return currentMap.get(digitProduct);
        }
        
        int limit = bounded ? number.charAt(pos) - '0' : 9;
        int result = 0;
        
        for (int d = 0; d <= limit; d++) {
            boolean newBounded = bounded && (d == limit);
            
            if (d == 0) {
                if (digitSum == 0) {
                    result += calculate(pos + 1, newBounded, digitSum, digitProduct, number);
                } else {
                    result += calculate(pos + 1, newBounded, digitSum, 0, number);
                }
            } else {
                result += calculate(pos + 1, newBounded, digitSum + d, digitProduct * d, number);
            }
        }
        
        currentMap.put(digitProduct, result);
        return result;
    }
}