class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;
        boolean k=true;
        for(char c='a';c<='z';c++)
        {
             if(sentence.indexOf(c)==-1) return false;
             else k=true; 

        }return k;

    }
}