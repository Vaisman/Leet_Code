package Amazon;

import org.junit.Test;

import java.util.*;

public class ThreeProductSuggestions {
    class TrieNode {
        Map<Character, TrieNode> children;
        List<String> products;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            products = new ArrayList<>();
            isWord = false;
        }
    }

    TrieNode root;
    String prefix;

    public List<List<String>> threeProductSuggestions(int numProducts, List<String> repository, String customerQuery) {
        root = new TrieNode();
        prefix = "";
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            add(repository.get(i).toLowerCase());
        }
        int len = customerQuery.length();
        char[] charArr = customerQuery.toCharArray();
        prefix = prefix + charArr[0];
        for (int i = 1; i < len; i++) {
            prefix = prefix + charArr[i];
            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                curr = next;
            }
            Collections.sort(curr.products);
            int k = 0;
            List<String> res = new ArrayList<>();
            while (!curr.products.isEmpty() && k < curr.products.size()) {
                if (k == 3) break;
                res.add(curr.products.get(k));
                k++;
            }
            result.add(res);
        }

        return result;
    }

    public void add(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.products.add(s);
        }
        curr.isWord = true;
    }

    @Test
    public void test() {
        int testNumProducts = 5;
        List<String> testRepository = new ArrayList<>();
        testRepository.add("Mouse");
        testRepository.add("monitor");
        testRepository.add("mousepad");
        testRepository.add("moneyPot");
        testRepository.add("mobile");
        String testQuery = "mouse";
        List<List<String>> result = threeProductSuggestions(testNumProducts, testRepository, testQuery);
        for (List<String> l : result) {
            System.out.println(Arrays.asList(l));
        }
    }
}
