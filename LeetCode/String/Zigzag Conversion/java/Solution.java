class Solution {
    public String convert(String s, int numrows) {
        int arr[]=new int[s.length()];
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(index<s.length()){
            for(int i=1;i<=numrows && index<s.length();i++){
                arr[index++]=i;
            }
            for(int i=numrows-1;i>=2 && index<s.length();i--){
                arr[index++]=i;
            }
        }
        for(int i=1;i<=numrows;i++){
            for(int j=0;j<s.length();j++){
            if(arr[j]==i) sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}