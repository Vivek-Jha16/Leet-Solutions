class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        // Har word kitni baar aana chahiye, ye store karenge
        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Har possible starting offset se sliding window chalayenge
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            // Current window mein words ki frequency
            Map<String, Integer> current = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Agar word words[] mein hai
                if (required.containsKey(word)) {

                    current.put(word, current.getOrDefault(word, 0) + 1);
                    count++;

                    // Agar kisi word ki frequency required se zyada ho gayi
                    while (current.get(word) > required.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);

                        current.put(leftWord, current.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Sabhi words exactly ek baar mil gaye
                    if (count == wordCount) {
                        result.add(left);

                        // Window ko next word ke liye move karo
                        String leftWord = s.substring(left, left + wordLen);
                        current.put(leftWord, current.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                } else {
                    // Unknown word mila, window reset
                    current.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}