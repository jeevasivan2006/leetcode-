class Solution {
    public boolean isHappy(int n) {
        while(n>4){
            int p=0;
            int a=1;
            while(n!=0){
                int f=n%10;
                 p=p+(f*f);
                 n=n/10;
            }
               n=p;
            
            }
             if(n==1){
            return true;
            }
            else
            return false;
            
        }
       
    }
