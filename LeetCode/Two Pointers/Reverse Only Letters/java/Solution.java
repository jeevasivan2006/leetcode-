class Solution {
    public String reverseOnlyLetters(String s) {
        int st=0;
        int end=s.length()-1;
        char[] chstr=s.toCharArray();
        while(st<end){
            char ch=s.charAt(st);
            char ch2=s.charAt(end);
            if(!Character.isLetter(ch)){
                st++;
            }
            else if(!Character.isLetter(ch2)){
                end--;
            }
            else{
                char temp=chstr[st];
                chstr[st]=chstr[end];
                chstr[end]=temp;
                st++;
                end--;
            }
        }
        return new String(chstr);
    }
}