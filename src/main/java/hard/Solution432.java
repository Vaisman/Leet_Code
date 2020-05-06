package hard;

import java.util.*;

public class Solution432 {
    Map<String,Integer> map;
    List<Set<String>> level;
    /** Initialize your data structure here. */
    public Solution432() {
        map = new HashMap();
        level = new ArrayList();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int index = map.getOrDefault(key,0);
        if(index > 0){
            level.get(index - 1).remove(key);
        }
        if(level.size() == index){
            level.add(new HashSet<String>());
        }

        map.put(key,index + 1);
        level.get(index).add(key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)){
            return;
        }
        int index = map.get(key);
        level.get(index - 1).remove(key);

        if(index > 1){
            map.put(key,index-1);
            level.get(index - 2).add(key);
        }else{
            map.remove(key);
        }

        if(level.get(level.size() - 1).isEmpty()){
            level.remove(level.size() - 1);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(!level.isEmpty() && !level.get(level.size() - 1).isEmpty()){
            return level.get(level.size() - 1).iterator().next();
        }else {
            return "";
        }
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(!level.isEmpty()){
            int min = 0;
            while(level.get(min).isEmpty()) min++;
            return level.get(min).iterator().next();
        }else {
            return "";
        }
    }
}
