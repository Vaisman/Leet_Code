package Amazon;

import org.junit.Test;

import java.util.*;

/**
 * AmazonPromeAirShipping
 * We are tracking down our rogue agent and she travels from place to place to avoid being tracked. Each of her travels are based on a list of itineraries in an unusual or incorrect order.
 * The task is to determine the complete route she will take.
 * You are given an array of routes containing her travel itineraries. Convert this into a complete, in-order list of the places she will travel.
 * Specification
 * findRoutes(routes)
 * Parameters
 * routes: Array<Array<String>> - Array of itineraries
 * Return Value
 * String - An ordered list or destinations
 * Constraints
 * All inputs have at least one valid, complete route
 * Examples
 * input;
 * [["USA","BRA"],["JPN","PHL"],["BRA","UAE"],["UAE","JPN"]]
 *
 * output;
 * "USA, BRA, UAE, JPN, PHL"
 * */

public class Flight {
    static class Node {
        Node prev;
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String next = "";
            String prev = "";
            if (this.next != null) {
                next = this.next.data;
            }
            if (this.prev != null) {
                prev = this.prev.data;
            }
            return " { next: " + next +
                    " prev: " + prev +
                    " data: " + this.data + " } ";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    static class Routes {
        Node head;
        List<Node> nodesList = new ArrayList<>();

        public Routes(String[][] routes) {
            for (String[] str : routes) {
                String data = str[0];
                String next = str[1];
                insert(data, next);
            }
        }

        public Node getNodeByString(String data) {
            for (Node node : nodesList) {
                String str = node.data;
                if (str.equalsIgnoreCase(data)) return node;
            }
            return null;
        }

        public void insert(String data, String next) {
            Node node = getNodeByString(data);
            Node nextNode = getNodeByString(next);

            if (nextNode == null) {
                nextNode = new Node(next);
            }
            if (node == null) {
                node = new Node(data);
            }
            nextNode.prev = node;
            node.next = nextNode;

            nodesList.remove(nextNode);
            nodesList.remove(node);
            nodesList.add(nextNode);
            nodesList.add(node);

            head = getRootNode();
        }

        public Node getRootNode() {
            for (Node node : nodesList) {
                if (node.prev == null) return node;
            }
            return null;
        }

        public String printList() {
            StringBuilder sb = new StringBuilder();
            Node currentNode = head;

            while (currentNode != null) {
                sb.append(currentNode.data).append(", ");
                currentNode = currentNode.next;
            }

            return sb.toString();
        }
    }

    //-------

    public static List<List<Integer>> findRoutes(List<List<Integer>> sources, List<List<Integer>> destinations,
                                                 int maxDist) {

        Map<Integer, List<List<Integer>>> map = new TreeMap<>();

        for (List<Integer> s : sources) {
            for (List<Integer> d : destinations) {
                int dist = s.get(1) + d.get(1);
                if (map.containsKey(dist)) {
                    List<List<Integer>> values = map.get(dist);
                    List<Integer> cords = new ArrayList<>();
                    cords.add(s.get(0));
                    cords.add(d.get(0));
                    values.add(cords);
                    map.put(dist, values);

                } else {
                    List<Integer> cords = new ArrayList<>();
                    cords.add(s.get(0));
                    cords.add(d.get(0));
                    List<List<Integer>> values = new ArrayList<>();
                    values.add(cords);
                    map.put(dist, values);
                }
            }
        }

        System.out.println(map);

        int max = Integer.MIN_VALUE;
        if (map.containsKey(maxDist)) {
            return map.get(maxDist);
        } else {

            Set<Integer> keys = map.keySet();
            for (int key : keys) {
                if (key > maxDist) {
                    break;
                }
                if (key > max && key < maxDist) {
                    max = key;
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return new ArrayList<>();
        } else {
            return map.get(max);
        }

    }

    public static List<List<Integer>> findRoutes1(List<List<Integer>> sources, List<List<Integer>> destinations,
                                                  int maxDist) {

        List<List<Integer>> match = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int firstVal = 0;
        int secondVal = 0;

        for (List<Integer> s : sources) {
            for (List<Integer> d : destinations) {
                int dist = s.get(1) + d.get(1);
                if (dist == maxDist) {
                    List<Integer> retList = new ArrayList<>();
                    retList.add(s.get(0));
                    retList.add(d.get(0));
                    match.add(retList);
                } else {
                    if (dist > max && dist < maxDist) {
                        max = dist;
                        firstVal = s.get(0);
                        secondVal = d.get(0);
                    }
                }
            }
        }

        if (match.size() > 0) {
            return match;
        } else if (max != Integer.MIN_VALUE) {
            List<Integer> retList = new ArrayList<>();
            retList.add(firstVal);
            retList.add(secondVal);
            match.add(retList);
            return match;
        }
        return new ArrayList<>();
    }

    @Test
    public void test() {
        Routes routes = new Routes(new String[][]{
                {"Chicago", "Winnipeg"},
                {"Halifax", "Montreal"},
                {"Montreal", "Toronto"},
                {"Toronto", "Chicago"},
                {"Winnipeg", "Seattle"}
        });
        System.out.println(routes.printList());
    }

    @Test
    public void test1() {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3000);
        list1.add(l1);

        l1 = new ArrayList<>();
        l1.add(2);
        l1.add(5000);
        list1.add(l1);

        l1 = new ArrayList<>();
        l1.add(3);
        l1.add(7000);
        list1.add(l1);

        l1 = new ArrayList<>();
        l1.add(4);
        l1.add(10000);
        list1.add(l1);

        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2000);
        list2.add(l2);

        l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3000);
        list2.add(l2);

        l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4000);
        list2.add(l2);

        l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5000);
        list2.add(l2);

        System.out.println(findRoutes(list1, list2, 7500));
        System.out.println(findRoutes1(list1, list2, 7500));
    }
}