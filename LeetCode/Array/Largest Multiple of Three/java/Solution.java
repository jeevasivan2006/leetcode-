class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int one = 0;
        int sec = 0;
        int [] num = new int[10];
        for(int digit: digits){
            num[digit]++;
            int val = digit%3;
            if(val==1){
                one++;
            }else if(val==2){
                sec++;
            }
        }
        int fone = one;
        int fsec = sec;
        one %=3;
        sec%=3;
        int data = one-sec;
        if(data!=0){    
            int rem = 1;
            if(data<0){
                rem = 2;
            }
            data = Math.abs(data);
            if(data==2){
                if(rem==1 && fsec>=3){//to solve 22111-> remove one 1
                    rem=2;data=1;
                }else if(rem==2 && fone>=3){
                    rem=1;data=1;
                }
            }
            for(int i=0;i<10 && data>0;i++){
                if(i%3==rem){
                    int dec = Math.min(data,num[i]);
                    data-=dec;
                    num[i]-=dec;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            while(num[i]>0){
                sb.append((char)(i+'0'));
                num[i]--;
            }
        }
        if(!sb.isEmpty() && sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }
}