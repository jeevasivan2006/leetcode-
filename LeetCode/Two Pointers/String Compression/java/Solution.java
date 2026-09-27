class Solution {
    public int compress(char[] chars) {
        int count=1;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<chars.length;i++){
            if(chars[i-1]==chars[i]){
                count++;
            }
            else{
                if(count==1){
                    sb.append(chars[i-1]);
                }
                else{
                    sb.append(chars[i-1]).append(count+"");// that (count+"") id used to convert count integer to string;
                    count=1;
                }
            }
        }
        if(count==1) sb.append(chars[chars.length-1]);
        else sb.append(chars[chars.length-1]).append(count+"");
        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}