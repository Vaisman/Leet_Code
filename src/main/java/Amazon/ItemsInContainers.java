package Amazon;

import org.junit.Test;

import java.util.*;
/**
 * Items in Containers
 *
 * Amazon would like to know how much inventory exists in their closed inventory compartments. Given a string s
 * consisting of items as "*" and closed compartments as an open and close "|", an array of starting indices
 * startIndices, and an array of ending indices endIndices, determine the number of items in closed compartments
 * within the substring between the two indices, inclusive.
 *
 * An item is represented as an asterisk ('*' = ascii decimal 42)
 * A compartment is represented as a pair of pipes that may or may not have items between them ('|' = ascii decimal 124).
 *
 * Example
 *
 * s = '|**|*|*'
 *
 * startIndices = [1, 1]
 *
 * endIndices = [5, 6]
 *
 * The string has a total of 2 closed compartments, one with 2 items and one with 1 item. For the first pair of
 * indices, (1, 5), the substring is '|**|*'. There are 2 items in a compartment.
 *
 * For the second pair of indices, (1, 6), the substring is '|**|*|' and there are 2 + 1 = 3 items in compartments.
 *
 * Both of the answers are returned in an array, [2, 3].
 *
 * Function Description .
 *
 * Complete the numberOfItems function in the editor below. The function must return an integer array that contains
 * the results for each of the startIndices[i] and endIndices[i] pairs.
 *
 * numberOfItems has three parameters:
 *
 * s: A string to evaluate
 *
 * startIndices: An integer array, the starting indices.
 *
 * endIndices: An integer array, the ending indices.
 *
 * Constraints
 *
 * 1 ≤ m, n ≤ 105
 * 1 ≤ startIndices[i] ≤ endIndices[i] ≤ n
 * Each character of s is either '*' or '|'
 *
 * Input Format For Custom Testing
 *
 * The first line contains a string, S.
 * The next line contains an integer, n, the number of elements in startIndices.
 * Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, startIndices[i].
 * The next line repeats the integer, n, the number of elements in endIndices.
 * Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, endIndices[i].
 *
 * Sample Case 0
 * Sample Input For Custom Testing
 *
 * STDIN Function
 *
 * *|*| -> s = "*|*|"
 *
 * 1 -> startIndices[] size n = 1
 * 1 -> startIndices = 1
 * 1 -> endIndices[] size n = 1
 * 3 -> endIndices = 3
 *
 * ** Sample Output**
 * 0
 *
 * Explanation
 * s = *|*|
 *
 * n = 1
 * startIndices = [1]
 * n = 1
 * startIndices = [3]
 *
 * The substring from index = 1 to index = 3 is '|'. There is no compartments in this string.
 *
 * Sample Case 1
 * Sample Input For Custom Testing
 *
 * STDIN Function
 *
 * *|*|*| -> s = "*|*|*|"
 * 1 -> startIndices[] size n = 1
 * 1 -> startIndices = 1
 * 1 -> endIndices[] size n = 1
 * 6 -> endIndices = 6
 *
 * Sample Output
 * 2
 *
 * Explanation
 * s = '*|*|*|'
 * n = 1
 * startIndices = [1]
 * n = 1
 * startIndices = [1]
 *
 * The substring from index = 1 to index = 6 is '||*|'. There are two compartments in this string at (index = 2,
 * index = 4) and (index = 4, index = 6). There are 2 items between these compartments.
 */

public class ItemsInContainers {

    public static List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();

        int countSoFar = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '|') {
                treeMap.put(i, countSoFar);
            } else {
                countSoFar++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<start.size(); i++) {
            list.add(number(treeMap, start.get(i) - 1, end.get(i) - 1));
        }
        return list;
    }

    static int number(NavigableMap<Integer, Integer> treemap, int start, int end) {
        int i = treemap.floorEntry(end).getValue() - treemap.ceilingEntry(start).getValue();
        return Math.max(i, 0);
    }

    public static List<Integer> numberOfItems1(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < startIndices.size(); i++) {
            int tempCount = 0;
            int count = 0;
            boolean startCompartment = false;

            for (int j = startIndices.get(i) - 1; j < endIndices.get(i); j++){
                char c = s.charAt(j);

                if (c == '|' && startCompartment == true) {
                    count += tempCount;
                    tempCount = 0;
                } else if (c == '|' && startCompartment == false) {
                    startCompartment = true;
                } else if (c == '*' && startCompartment == true) {
                    tempCount++;
                }
            }

            list.add(count);
        }

        return list;
    }

  // ----------
  public List<Integer> numberOfItems2(String s, List<Integer> start, List<Integer> end) {
      NavigableMap<Integer, Integer> treeMap = new TreeMap<>();

      int countSoFar = 0;
      for (int i = 0; i< s.length(); i++) {
          if (s.charAt(i) == '|') {
              treeMap.put(i, countSoFar);
          } else {
              countSoFar++;
          }
      }
      List<Integer> list = new ArrayList<>();
      for(int i = 0; i<start.size(); i++) {
          list.add(number1(treeMap, start.get(i) - 1, end.get(i) - 1));
      }
      return list;
  }

    int number1(NavigableMap<Integer, Integer> treemap, int start, int end) {
        int i = treemap.floorEntry(end).getValue() - treemap.ceilingEntry(start).getValue();
        return Math.max(i, 0);
    }

    @Test
    public void test() {
        String[] s = {"|**|*|*", "*|*|", "*|*|*|", "|**|***|*|****|", "|**|*|***", "***|**|*" };
        Integer[][] startIndices = {{1, 1}, {1}, {1},{9, 5}, {1,1}, {1} };
        Integer[][] endIndices = {{5, 6}, {3}, {6}, {15, 14}, {7,8}, {3}};

        for(int k = 0; k < s.length; k++){
            List<Integer> res = numberOfItems1(s[k], Arrays.asList(startIndices[k]), Arrays.asList(endIndices[k]));
            for(int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + ",");
            }
            System.out.println();
        }
    }
}