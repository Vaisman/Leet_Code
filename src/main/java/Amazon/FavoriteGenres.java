package Amazon;

import org.junit.Test;

import java.util.*;

public class FavoriteGenres {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songsToGenre = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                songsToGenre.put(song, genre);
            }
        }

        Map<String, Integer> count = null;
        int max = 0;
        for (String user : userMap.keySet()) {
            count = new HashMap<>();
            max = 0;
            res.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            for (String song : songs) {
                String genre = songsToGenre.get(song);
                int c = count.getOrDefault(genre, 0) + 1;
                count.put(genre, c);
                max = Math.max(c, max);
            }
            for (String key : count.keySet()) {
                if (count.get(key) == max) {
                    res.get(user).add(key);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        Map<String, List<String>> map1 = new HashMap<>();
        map1.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        map1.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> map2 = new HashMap<>();
        map2.put("Rock", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        map2.put("Dubstep", Arrays.asList("song7"));
        map2.put("Techno", Arrays.asList("song2", "song4"));
        map2.put("Pop", Arrays.asList("song5", "song6"));
        map2.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> res = favoritegenre(map1, map2);
    }
}
