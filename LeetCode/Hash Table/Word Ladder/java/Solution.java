class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String cstr = queue.poll();
                for (int j = 0; j < cstr.length(); j++) {
                    char[] temp = cstr.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {//hit chck ait bit cit like this
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if (newWord.equals(endWord)) return len + 1;
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}