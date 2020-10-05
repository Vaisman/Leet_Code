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

    public static ArrayList<String> popularNToys1(int numToys, int topToys, List<String> toys, int numQuotes,
                                                 List<String> quotes) {
        Map<String, Integer> counter = new HashMap<>();
        for (String quote : quotes) {
            if (toys.contains(quote.toLowerCase())) {
                if (!counter.containsKey(quote)) {
                    counter.put(quote, 1);
                } else {
                    counter.replace(quote, counter.get(quote) + 1);
                }
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) ->
                counter.get(w1).equals(counter.get(w2)) ? w1.compareTo(w2) : counter.get(w1) - counter.get(w2));
        for (String toy : counter.keySet()) {
            pq.offer(toy);
            if (pq.size() > topToys) {
                pq.poll();
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
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
        System.out.println(popularNToys1(numToys, topToys, toys, numQuotes, quotes));
    }
}
