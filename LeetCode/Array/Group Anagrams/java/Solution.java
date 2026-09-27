class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        int n = strs.length;

        for(int i=0;i<n;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            mp.computeIfAbsent(key,k->new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}