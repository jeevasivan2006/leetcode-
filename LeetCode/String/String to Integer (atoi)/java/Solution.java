class Solution {
    public int myAtoi(String s) {
        String s1 = s.strip();
        int len = s1.length();
        if(len==0) return 0;
        int i=0,sign=1;
        long num=0;
        if(s1.charAt(0)=='-'){
            sign=-1;
            i++;
        }
        else if(s1.charAt(0)=='+'){
            i++;
        }
        while(i<len && s1.charAt(i)>='0' && s1.charAt(i)<='9'){
            num = num*10 + (s1.charAt(i)-'0');
            if(sign*num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(sign*num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign*num);
    }
}