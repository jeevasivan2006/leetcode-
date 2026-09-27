class Solution {
    public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        char[] ch=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(vowels.indexOf(ch[i])==-1){
             i++;
            }
            else if(vowels.indexOf(ch[j])==-1){
                j--;
            }
            else {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        String res=new String(ch);
        return res;
    }
}