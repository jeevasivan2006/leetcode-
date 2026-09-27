class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
       int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);                 
            if(s.charAt(i)=='*'){
                if(sb.length()!=0){
                sb.deleteCharAt(sb.length()-1);
            }
            }
            else if(s.charAt(i)=='#'){
                sb.append(sb);
            }
            else if(s.charAt(i)=='%'){
                sb.reverse();
            }
             else{
                sb.append(s.charAt(i));
            }
           i++;
        }
        return sb.toString();
    }
}