class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder(words.length);
        for(String w:words){
            int s=0;
            for(int i=0;i<w.length();i++){
                s+=weights[w.charAt(i)-'a'];
            }
            sb.append((char)('z'-(s%26)));
        }
        return sb.toString();
    }
}