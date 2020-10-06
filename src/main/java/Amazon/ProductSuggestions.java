package Amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSuggestions {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String st = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for (String s : products) {
                if(list.size()==3)
                    break;
                if (s.startsWith(st)) {
                    list.add(s);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    @Test
    public void test() {
        suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }
}
