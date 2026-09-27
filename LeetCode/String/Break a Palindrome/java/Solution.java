class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        char[] a=palindrome.toCharArray();
        boolean f=true;
        for(int i=0;i<a.length/2;i++)
        if(a[i]!='a'){
            a[i]='a';
            f=false;
            break;
        }
        if(f==true)
        a[a.length-1]='b';
        return new String(a);
    }
}