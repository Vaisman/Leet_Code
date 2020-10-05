package Amazon;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ToysProblem {
    public ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes) {
        Map<String, Integer> mapToys = new HashMap<>();
        for (int iToy = 0; iToy < numToys; iToy++) {
            String toy = toys.get(iToy);
            for (int quote = 0; quote < numQuotes; quote++) {
                int occ = findOcc(toy, quotes.get(quote));
                Integer nbToys = 0;
                if ((nbToys = mapToys.get(toy)) == null)
                    mapToys.put(toy, occ);
                else
                    mapToys.put(toy, nbToys + occ);
            }
        }

        return new ArrayList<>(byTop(topToys, mapToys));
    }
    // METHOD SIGNATURE ENDS

    public int findOcc(String toy, String quote) {
        int cpt=0;
        int idx=0;
        while ((idx=quote.indexOf(toy, idx)) > -1) {
            cpt++;
            idx += toy.length();
        }
        return cpt;
    }

    public List<String> byTop(int topToys, Map<String, Integer> mapToys) {
        return mapToys.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topToys)
                .map(e->e.getKey())
                .collect(Collectors.toList());
    }

    @Test
    public void test(){
        int numToys = 5;
        int topToys = 2;
        List<String> toys = Arrays.asList("anacell", "betacelluar", "cetracular", "deltacellular", "eurocell");
        int numQuotes = 5;
        List<String> quotes = Arrays.asList(
                "i love anacell best service provider anacell",
                "betacelluar has great service",
                "deltacellular provies much more better service than betacelluar",
                "cetracular is worst than eurocell",
                "betacelluar is better than deltacellular");
        System.out.println(popularNToys(numToys, topToys, toys, numQuotes, quotes));
    }
}
