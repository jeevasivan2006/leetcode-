class Solution {
    public int findNthDigit(int n) {
        long digits = 1;        // length of numbers (1-digit, 2-digit, etc.)
        long count = 9;         // count of numbers in that range
        long start = 1;         // starting number of the range

        // Step 1: Identify which range n belongs to
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the exact number that contains the nth digit
        long number = start + (n - 1) / digits;

        // Step 3: Find which digit in that number
        String numStr = String.valueOf(number);
        int index = (n - 1) % (int)digits;
        return numStr.charAt(index) - '0';
    }
}