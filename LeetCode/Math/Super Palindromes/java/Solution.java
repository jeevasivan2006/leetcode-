class Solution {
    static List<Long> palindromes = new ArrayList<>();
    public int superpalindromesInRange(String left, String right) {

        if(palindromes.size() == 0)
            getPalindromes(1, (long)1e18 - 1);

        int ans = 0;
        long low = Long.parseLong(left), high = Long.parseLong(right);
        for(long x:palindromes){
            if(x >= low && x <= high)
                ans++;
        }

        return ans;
    }

    public static void getPalindromes(long left, long right) {

        int low =  (int) Math.ceil(Math.sqrt(left));
        int high = (int) Math.floor(Math.sqrt(right));

        int n = Integer.toString(high).length();
    
        palindromes.add(9L);
        
        StringBuilder s = new StringBuilder();
        dfs(low, high, n, s);
        for(char c = '0'; c <= '2'; ++c){
            s.append(c);
            dfs(low, high, n, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    static void dfs(int low, int high, int n, StringBuilder s){
       
        if(s.length() > n) return;

        if(s.length() > 0 && s.charAt(0) != '0'){
            long x = Long.parseLong(s.toString());
            if(x > high) return;
            if(x >= low && isPalindrome(x * x))
                palindromes.add(x * x);
        }

        for(char c = '0'; c <= '2'; ++c){
            s.insert(0, c);
            s.append(c);
            dfs(low, high, n, s);
            s.deleteCharAt(0);
            s.deleteCharAt(s.length() - 1);
        }

    }

    static boolean isPalindrome(long x){
        String s = Long.toString(x);
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }
}