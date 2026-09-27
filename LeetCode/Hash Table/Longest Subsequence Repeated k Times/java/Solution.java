class Solution {
    private String result = "";
    private String input;
    private int repeatCount;

    public String longestSubsequenceRepeatedK(String input, int repeatCount) {
        // Store input and repeatCount as class fields
        this.input = input;
        this.repeatCount = repeatCount;

        // Calculate frequency of each character and divide by repeatCount
        int[] freq = new int[26];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            freq[i] /= repeatCount;
        }

        // Generate subsequences and find the best one
        generateSubsequence(new StringBuilder(), freq);
        return result;
    }

    private void generateSubsequence(StringBuilder current, int[] freq) {
        // Check if current subsequence is valid and update result
        if (!current.isEmpty()) {
            if (existsKTimes(current)) {
                String currentStr = current.toString();
                if (current.length() > result.length() || 
                    (current.length() == result.length() && currentStr.compareTo(result) > 0)) {
                    result = currentStr;
                }
            } else {
                return; // Early pruning: stop if subsequence doesn't exist k times
            }
        }

        // Stop if maximum length of 7 is reached
        if (current.length() >= 7) {
            return;
        }

        // Add characters from 'z' to 'a' to prioritize lexicographically larger subsequences
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            freq[i]--;
            current.append((char) ('a' + i));
            generateSubsequence(current, freq);
            current.deleteCharAt(current.length() - 1);
            freq[i]++;
        }
    }

    private boolean existsKTimes(StringBuilder candidate) {
        // Return false for empty candidate
        if (candidate.isEmpty()) {
            return false;
        }
        // Count occurrences of candidate in input
        int matchIndex = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == candidate.charAt(matchIndex)) {
                matchIndex++;
                if (matchIndex == candidate.length()) {
                    matchIndex = 0;
                    count++;
                    if (count >= repeatCount) {
                        return true; // Early exit if repeatCount is reached
                    }
                }
            }
        }
        return count >= repeatCount;
    }
}