package Amazon;

import org.junit.Test;

import java.util.*;

public class MaxProfitFromSuppliers {
    // max_profit
    // maxProfit
    static long highestProfit(int numSuppliers, List<Long> inventory, long order) {
        int profit = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(inventory.size(), Collections.reverseOrder());
        pq.addAll(inventory);

        while (order != 0 && !pq.isEmpty()) {
            Long top = pq.poll();
            profit += top;
            order--;
            pq.add(top - 1);
        }

        return profit;
    }

    static long highestProfit1(int numSuppliers, List<Long> inventory, long order) {
        int size = inventory.size();
        Long[] list = new Long[size];
        for (int i = 0; i < size; i++)
            list[i] = inventory.get(i);

        Arrays.sort(list, Comparator.reverseOrder());

        Long[] arr = new Long[size + 1];
        for (int i = 0; i < size; i++)
            arr[i] = list[i];

        arr[size] = Long.valueOf(0);
        int supIndx = 1;
        long maxPro = 0;
        while (order >= 0 && supIndx < arr.length) {
            while (supIndx < arr.length && arr[supIndx - 1] == arr[supIndx])
                supIndx++;
            if (arr[supIndx - 1] == 0)
                break;
            int supMulti = supIndx;
            long diff = arr[supIndx - 1] - arr[supIndx];
            long localCountToOrder = diff * supMulti;
            long localPro = arr[supIndx - 1];
            localCountToOrder = Math.min(order, localCountToOrder);
            order = order - localCountToOrder;
            while (localCountToOrder > 0 && localPro >= arr[supIndx]) {
                long currCountToTake = Math.min(supMulti, localCountToOrder);
                maxPro = maxPro + localPro * currCountToTake;
                localPro--;
                localCountToOrder = localCountToOrder - currCountToTake;
            }
            supIndx++;
        }
        return maxPro;
    }

    @Test
    public void main() {
        List<Long> inventory = new ArrayList<>();
        inventory.add((long) 2);
        inventory.add((long) 5);
        System.out.println(highestProfit(2, inventory, 4));
        System.out.println(highestProfit1(2, inventory, 4));
    }
}
