class Solution {
    public int balancedStringSplit(String s) {
              
        int count=0;int bal=0;int a=0;
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i) == 'R')
                bal++;
            else if(s.charAt(i)=='L')
                bal--;
            
               if(bal==0)
                a++;
               
        }
        return a;
    }
}