class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i<nums.length ; i++){
            int check = cntDivisor(nums[i]);
            if(check != -1){
                sum += check;
            }
        }
        return sum;
    }
    public int cntDivisor(int m){
        int cnt = 0;
        int sum = 0;
        for(int i = 1 ; i*i <= m ; i++){
            if(m % i == 0){
                cnt++;
                sum += i;

                if((m/i) != i){
                    cnt++;
                    sum += m/i;
                }
            }
        }
        if(cnt == 4)
            return sum;
        return -1;
    }
}