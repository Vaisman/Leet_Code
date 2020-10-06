package Amazon;

import org.junit.Test;

import java.util.*;

public class LRUCacheMisses {
    public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        LRUCache cache = new LRUCache(maxCacheSize);
        int count = num;
        for (int page : pages) {
            if (cache.put(page, 0)) {
                count--;
            }
        }
        return count;
    }

    public static class LRUCache {
        int _capacity;
        LinkedHashMap<Integer, Integer> _map;
        public LRUCache(int capacity) {
            _capacity = capacity;
            _map = new LinkedHashMap<>();
        }

        // Time O(1) Space O(1)
        public int get(int key) {
            int value = -1;
            if (_map.containsKey(key)) {
                value = _map.get(key);
                _map.remove(key);
                _map.put(key, value);
            }
            return value;
        }

        // Time O(1) Space O(1)
        public boolean put(int key, int value) {
            boolean cached = false;
            if (_map.containsKey(key)) {
                _map.remove(key);
                cached = true;
            } else if (_map.size() == _capacity) {
                Iterator iter = _map.entrySet().iterator();
                iter.next();
                iter.remove();
            }
            _map.put(key, value);
            return cached;
        }
    }

    @Test
    public void test() {
        System.out.println(lruCacheMisses(6, Arrays.asList(1,2,1,3,1,2), 2));
    }
}
