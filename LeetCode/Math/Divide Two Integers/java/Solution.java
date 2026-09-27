class Solution {
    public int divide(int dividend, int divisor) {
        int res = 0;
        boolean sign = (dividend < 0) != (divisor < 0);

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int a = (dividend > 0) ? -dividend : dividend;
        int b = (divisor > 0) ? -divisor : divisor;

        while (a <= b) {
            int temp = b;
            int multiple = 1;
            while (a <= temp + temp && temp >= Integer.MIN_VALUE / 2) {
                temp += temp;
                multiple += multiple;
            }
            a -= temp;
            res += multiple;
        }

        return sign ? -res : res;   
    }
}