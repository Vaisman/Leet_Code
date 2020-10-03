package Amazon;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Trie root = new Trie();
        Trie curr = root;

        // insert banned words into Trie
        for (String ban : banned) {
            for (int i = 0; i < ban.length(); i++) { // my be foreach to remove duplicates
                int idx = ban.charAt(i) - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new Trie();
                }
                curr = curr.next[idx];
            }
            curr.banned = true;
            curr = root;
        }

        int maxCount = 0;
        String mostFreqWord = "";
        paragraph = paragraph.toLowerCase();
        char[] pArray = paragraph.toCharArray();
        // insert words in paragraph into Trie

        for (int start = 0, end = 0; start < pArray.length; start = end + 1) {
            // skip non-letter characters
            while (start < pArray.length && (pArray[start] < 'a' || pArray[start] > 'z')) {
                start++;
            }
            // insert consecutive letters(words) into Trie
            for (end = start; end < pArray.length && (pArray[end] >= 'a' && pArray[end] <= 'z'); end++) {
                int idx = pArray[end] - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new Trie();
                }
                curr = curr.next[idx];
            }
            // update statistics
            if (curr != root && !curr.banned) {
                curr.count++;
                if (curr.count > maxCount) {
                    mostFreqWord = paragraph.substring(start, end);
                    maxCount = curr.count;
                }
            }
            curr = root;
        }
        return mostFreqWord;
    }

    private class Trie {
        private Trie[] next = new Trie[26];
        private int count;
        private boolean banned;
    }
}
