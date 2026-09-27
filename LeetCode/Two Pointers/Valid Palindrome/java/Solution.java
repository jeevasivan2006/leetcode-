class Solution {
    public boolean isPalindrome(String s) {
        //StringBuilder sb=new StringBuilder();
        String r=s.toLowerCase().replaceAll("[^a-z0-9]","");
        String re = new StringBuilder(r).reverse().toString();
        if(r.contains(re)){
            return true;
        }
        return false;
    }
}