class Solution {
    public int subtractProductAndSum(int n) {
        int add=0;
      
        int mau=1;
        while(n>0){
            int f=n%10;
            add+=f;
            mau*=f;
            n/=10;
        }
         int sum=mau-add;
         return sum;
    }
}