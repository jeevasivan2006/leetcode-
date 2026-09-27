class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s1=new int[128];
        int[] t1=new int[128];
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(s1[ch1]==0&&t1[ch2]==0){
                s1[ch1]=ch2;
                t1[ch2]=ch1;
            }
            else {
                if(s1[ch1]!=ch2&&t1[ch2]!=ch1)
                return false;
            }
        }
        return true;
    }
}