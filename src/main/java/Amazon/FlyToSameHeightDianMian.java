package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FlyToSameHeightDianMian {
    public static void main(String[] args) {
        System.out.println(findRoutes(new int[]{3, 5, 5, 4, 5, 3}));
    }

    public static int findRoutes(int[] array) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        int route = 0;
        for (int i = 0; i < array.length; i++) {
            if (stack.size() == 0 || stack.peek() >= array[i]) {
                stack.add(array[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= array[i]) {
                    int val = stack.pop();
                    if (map.containsKey(val) || val == array[i]) {
                        route += 2;
                    } else {
                        map.put(val, 1);
                    }
                }
                map.clear();
                stack.add(array[i]);
            }
        }
        return route;
    }
}