package Amazon;

import org.junit.Test;

import java.util.*;

public class LargestItemAssociation {

    class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    class Node {
        String item;
        String boss;
        int size;
        LinkedList<String> component;

        Node(String s) {
            item = s;
            boss = s;
            size = 1;
            component = new LinkedList<>();
            component.add(s);
        }
    }

    class UnionFind {
        Map<String, Node> map;
        int maxSize;
        List<String> largestComponent;

        UnionFind() {
            map = new HashMap<>();
            maxSize = 0;
            largestComponent = new LinkedList<>();
        }

        public void union(String item1, String item2) {
            if (!map.containsKey(item1)) {
                map.put(item1, new Node(item1));
            }
            if (!map.containsKey(item2)) {
                map.put(item2, new Node(item2));
            }
            if (isConnected(item1, item2) || item1.equals(item2)) return;

            Node boss1 = map.get(find(item1));
            Node boss2 = map.get(find(item2));

            // always choose lexicographically smaller item to be the boss of connected component
            if (boss1.component.get(0).compareTo(boss2.component.get(0)) < 0) {
                connect(boss1, boss2);
            } else {
                connect(boss2, boss1);
            }
        }

        public void connect(Node n1, Node n2) {
            n1.size += n2.size;
            n1.component.addAll(n2.component);
            n2.component = null;    // for saving space
            n2.boss = n1.item;

            if (n1.size > maxSize) {
                maxSize = n1.size;
                largestComponent = n1.component;
            } else if (n1.size == maxSize) {
                // if new component is same size but lexicographically smaller, update
                if (largestComponent.get(0).compareTo(n1.component.get(0)) > 0) {
                    largestComponent = n1.component;
                }
            }
        }

        public boolean isConnected(String s1, String s2) {
            String boss1 = find(s1);
            String boss2 = find(s2);
            return boss1.equals(boss2);
        }

        public String find(String item) {
            Node node = map.get(item);
            while (!node.boss.equals(node.item)) {
                node = map.get(node.boss);
            }
            Node tail = map.get(item);
            while (!tail.boss.equals(node.item)) {
                String next = tail.boss;
                tail.boss = node.item;
                tail = map.get(next);
            }
            return node.item;
        }
    }

    public List<String> largestItemAssociation1(List<PairString> itemAssociation) {
        if (itemAssociation == null || itemAssociation.isEmpty()) {
            return Collections.emptyList();
        }

        UnionFind uf = new UnionFind();
        for (PairString p : itemAssociation) {
            uf.union(p.first, p.second);
        }

        // print map
        for (Map.Entry<String, Node> entry : uf.map.entrySet()) {
            System.out.print(entry.getKey() + "-" + entry.getValue().boss + ", ");
        }
        System.out.println();

        return uf.largestComponent;
    }

    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        if (itemAssociation == null || itemAssociation.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (PairString pair : itemAssociation) {
            Set<String> set = map.getOrDefault(pair.first, new TreeSet<>());
            set.add(pair.first);
            set.add(pair.second);
            set.addAll(map.getOrDefault(pair.second, new TreeSet<>()));
            map.put(pair.first, set);
            map.put(pair.second, set);
        }

        Set<String> checked = new HashSet<>();
        Queue<List<String>> pq = new PriorityQueue<>((l1, l2) -> (l1.size() != l2.size() ? l2.size() - l1.size() : l1.get(0).compareTo(l2.get(0))));

        for (Map.Entry<String, Set<String>> item : map.entrySet()) {
            if (checked.contains(item.getKey())) {
                continue;
            }
            pq.add(new ArrayList<>(item.getValue()));
            checked.addAll(item.getValue());
        }
        return pq.remove();
    }

    @Test
    public void test0() {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item3", "item4"),
                new PairString("item4", "item5"),
                new PairString("item0", "item2"),
                new PairString("item1", "item2")
        );

        largestItemAssociation(pairs);
    }

    @Test
    public void test1() {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item3", "item2"), // -> item1, item3, item2
                new PairString("item3", "item4"), //
                new PairString("item2", "item1") //
        );

        largestItemAssociation1(pairs);
    }

    @Test
    public void test2() {
        List<PairString> list = new ArrayList<>();
        list.add(new PairString("item1", "item2"));
        list.add(new PairString("item3", "item4"));
        list.add(new PairString("item4", "item5"));
        // item3 item4 item5
        System.out.println(largestItemAssociation(list).toString());
        System.out.println();

        list = new ArrayList<>();
        list.add(new PairString("z", "b"));
        list.add(new PairString("z", "c"));
        list.add(new PairString("c", "d"));
        list.add(new PairString("e", "f"));
        // b c z d
        System.out.println(largestItemAssociation(list).toString());
        System.out.println();

        list = new ArrayList<>();
        list.add(new PairString("y", "x"));
        list.add(new PairString("a", "y"));
        list.add(new PairString("d", "e"));
        list.add(new PairString("e", "f"));
        // a x y
        System.out.println(largestItemAssociation(list).toString());
        System.out.println();

        list = new ArrayList<>();
        list.add(new PairString("a", "b"));
        list.add(new PairString("b", "a"));
        list.add(new PairString("c", "e"));
        list.add(new PairString("e", "f"));
        list.add(new PairString("f", "c"));
        // c e f
        System.out.println(largestItemAssociation(list).toString());
        System.out.println();

        list = new ArrayList<>();
        list.add(new PairString("a", "b"));
        list.add(new PairString("b", "a"));
        list.add(new PairString("a", "c"));
        list.add(new PairString("d", "e"));
        list.add(new PairString("e", "f"));
        list.add(new PairString("f", "e"));
        list.add(new PairString("b", "e"));

        list.add(new PairString("w", "x"));
        list.add(new PairString("x", "y"));
        list.add(new PairString("y", "z"));
        // a b c d e f
        System.out.println(largestItemAssociation(list).toString());
        System.out.println();
    }
}

    /*

#include <list>
#include <set>
#include <vector>
using namespace std;

struct PairString {
	string first;
	string second;

	PairString(string first, string second) {
		this->first = first;
		this->second = second;
	}
};

struct Solution {
	static list<string> largestItemAssociation(list<PairString> itemAssociation) {
		vector<set<string>> dataList;

		for (const auto pairItem : itemAssociation)
		{
			bool found = false;
			for (auto& eachData : dataList)
			{
				// O(2 * log n)
				if ((eachData.find(pairItem.first) != eachData.end()) || (eachData.find(pairItem.second) != eachData.end()))
				{
					found = true;
					eachData.insert(pairItem.first);
					eachData.insert(pairItem.second);

					break;
				}
			}

			// it's a new PairString!
			if (found == false)
				dataList.push_back(set<string> {pairItem.first, pairItem.second });
		}

		// to find the longest data
		int i = 0;
		int maxSizeDataIndex = 0;
		int currMaxSize = 0;
		for (const auto eachData : dataList)
		{
			if (currMaxSize < eachData.size())
			{
				currMaxSize = eachData.size();
				maxSizeDataIndex = i;
			}

			++i;
		}

		// to change the format from set to list
		list<string> result;
		for (auto eachString : dataList[maxSizeDataIndex])
			result.push_back(eachString);

		return result;
	}
};

int main(void)
{
	list<PairString> input1{
		PairString("item1", "item2"),
		PairString("item3", "item4"),
		PairString("item4", "item5")
	};

	list<PairString> input2{
		PairString("item3","item4"),
		PairString("item1","item2"),
		PairString("item5","item6"),
		PairString("item4","item5"),
		PairString("item2","item7"),
		PairString("item7","item8")
	};

	list<PairString> input3{
		PairString("item3","item4"),
		PairString("item1","item2"),
		PairString("item5","item6"),
		PairString("item4","item5"),
		PairString("item2","item7"),
		PairString("item7","item8"),
		PairString("item2","item3"),
		PairString("item6","item7"),
		PairString("item0","item2")
	};

	Solution::largestItemAssociation(input1);

	return 0;
}

    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        if (itemAssociation == null || itemAssociation.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (PairString pair : itemAssociation) {
            Set<String> set = map.getOrDefault(pair.first, new TreeSet<>());
            set.add(pair.first);
            set.add(pair.second);
            set.addAll(map.getOrDefault(pair.second, new TreeSet<>()));
            map.put(pair.first, set);
            map.put(pair.second, set);
        }

        Set<String> checked = new HashSet<>();
        Queue<List<String>> pq = new PriorityQueue<>((l1, l2) -> (l1.size() != l2.size() ? l2.size() - l1.size() : l1.get(0).compareTo(l2.get(0))));

        for (Map.Entry<String, Set<String>> item : map.entrySet()) {
            if (checked.contains(item.getKey())) {
                continue;
            }
            pq.add(new ArrayList<>(item.getValue()));
            checked.addAll(item.getValue());
        }
        return pq.remove();
    }

    @Test
    public void test() {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item3", "item2"), // -> item1, item3, item2
                new PairString("item3", "item4"), //
                new PairString("item2", "item1") //
        );

        largestItemAssociation(pairs);
    }
}

BFS
public class ItemAssociation {
    class PairString {
        String first;
        String second;

        PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    class Node {
        String val;
        Map<String, Node> next;

        Node(String _val) {
            val = _val;
            next = new HashMap<>();
        }
    }

    private Map<String, Node> graph;

    private void buildGraph(List<PairString> itemAssociation) {
        graph = new HashMap<>();
        for (PairString string : itemAssociation) {
            Node first = graph.getOrDefault(string.first, new Node(string.first));
            Node second = graph.getOrDefault(string.second, new Node(string.second));

            first.next.putIfAbsent(string.second, second);
            graph.putIfAbsent(string.first, first);

            graph.putIfAbsent(string.second, second);
        }
    }

    private List<String> bfs() {
        Queue<List<String>> pq = new PriorityQueue<>((a, b) -> {
            if (a.size() != b.size()) {
                return b.size() - a.size();
            }
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).compareTo(b.get(i)) != 0) {
                    return a.get(i).compareTo(b.get(i));
                }
            }
            return 0;
        });

        for (String key : graph.keySet()) {
            List<String> values = new LinkedList<>();
            Queue<Node> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            Node root = graph.get(key);
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (node != null && !visited.contains(node.val)) {
                        values.add(node.val);
                        visited.add(node.val);
                        for (Node child : node.next.values()) {
                            queue.offer(child);
                        }
                    }
                }
            }

            pq.offer(values);
        }

        return pq.peek();
    }

    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        buildGraph(itemAssociation);
        return bfs();
    }

    public static void main(String[] args) {
        ItemAssociation ia = new ItemAssociation();
        PairString[] strs = {
                ia.new PairString("item1", "item2"),
                ia.new PairString("item3", "item4"),
                ia.new PairString("item4", "item5")
        };
        List<PairString> pairs = Arrays.asList(strs);
        List<String> result = ia.largestItemAssociation(pairs);
        System.out.print("[");
        for (String str : result) {
            System.out.print(str + ",");
        }
        System.out.println("]");
    }
}
 */