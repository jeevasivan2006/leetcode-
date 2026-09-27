class Solution {
    public int addDigits(int num) {
         int sum=0;
        while(num>0){
            if(num>9){
                int a=num/10;
            int f=num%10;
            num=a+f;
            
           }
           else
           return num;
        }
        return num;
    }
}