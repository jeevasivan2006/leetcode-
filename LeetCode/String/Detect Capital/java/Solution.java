class Solution {
    public boolean detectCapitalUse(String word) {
        int cap=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
          if(c>='A'&&c<='Z'){
                cap++;
            }
         }
        if (cap == word.length()) {
        return true;}
        if (cap == 0){
             return true;}
        if (cap == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;}
       return false; 
   
    }
}