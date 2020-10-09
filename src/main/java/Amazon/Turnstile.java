package Amazon;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;

public class Turnstile {
    class TurnstileEntity {
        int index ;
        int second;
        int direction;

        TurnstileEntity(int i, int second, int direction) {
            this.index = i;
            this.second = second;
            this.direction = direction;
        }
    }

    public  int[] getTimes(int customers, int[] times, int[] directions) {
        if (customers == 0) {
            return new int[]{};
        }

        // MinHeap respecting priority to time and index.
        PriorityQueue<TurnstileEntity> minHeap = new PriorityQueue<>(customers, (e1, e2) -> {
            if (e1.second < e2.second) {
                return -1;
            }
            if (e1.second > e2.second) {
                return 1;
            }

            return (e1.index < e2.index) ? -1 : 1;
        });

        for (int i = 0; i < customers; i++) {
            minHeap.add(new TurnstileEntity(i, times[i], directions[i]));
        }

        int prevDirection = 1;
        int[] result = new int[customers];

        while (minHeap.size() > 1) {
            TurnstileEntity c1 = minHeap.poll();
            TurnstileEntity c2 = minHeap.poll();
            boolean c1Chosen = true;

            if (c1.second == c2.second && (c2.direction == prevDirection && c1.direction != prevDirection)) {
                c1Chosen = false;
            }

            if (c1Chosen) {
                prevDirection = c1.direction;
                result[c1.index] = c1.second;

                if (c2.second - c1.second > 1) {
                    prevDirection = 1;
                }

                if (c1.second == c2.second) {
                    c2.second++;
                }
                minHeap.add(c2);
            } else {
                prevDirection = c2.direction;
                result[c2.index] = c2.second;

                c1.second++;
                minHeap.add(c1);
            }
        }

        if (!minHeap.isEmpty()) {
            TurnstileEntity lastOne = minHeap.poll();
            result[lastOne.index] = lastOne.second;
        }

        return result;
    }

    @Test
    public void test() {
        int customers;
        int[] times;
        int[] directions;
        int[] expected;
        int[] actual;

        // Test 1
        customers = 4;
        times = new int[]{0, 0, 1, 5};
        directions = new int[]{0, 1, 1, 0};
        expected = new int[]{2, 0, 1, 5};
        actual = getTimes(customers, times, directions);
        assertArrayEquals(expected, actual);

        // Test 2
        customers = 5;
        times = new int[]{0, 1, 1, 3, 3};
        directions = new int[]{0, 1, 0, 0, 1};
        expected = new int[]{0, 2, 1, 4, 3};
        actual = getTimes(customers, times, directions);
        assertArrayEquals(expected, actual);

        // Test 3
        customers = 5;
        times = new int[]{0, 1, 1, 4, 4};
        directions = new int[]{1, 0, 1, 0, 1};
        expected = new int[]{0, 2, 1, 5, 4};
        actual = getTimes(customers, times, directions);
        assertArrayEquals(expected, actual);

        // Test 4
        customers = 5;
        times = new int[]{0, 1, 1, 4, 4};
        directions = new int[]{1, 0, 1, 0, 0};
        expected = new int[]{0, 2, 1, 4, 5};
        actual = getTimes(customers, times, directions);
        assertArrayEquals(expected, actual);
    }
}


/*
struct cmp {
    bool operator()(const tuple<int, int, int> &a, const tuple<int, int, int> &b) const {
        int a0, a1, a2, b0, b1, b2;
        std::tie(a0, a1, a2) = a;
        std::tie(b0, b1, b2) = b;
        if (a1 == b1) {
            if (b2 == a2) {
                return a0 > b0;
            }
            return a2 < b2;
        }
        return a1 > b1;
    }
};
class Solution {
  public:
  vector<int> pass_through_turnstile(int n, vector<int> &arrTime, vector<int> &directions) {
      // Priority_Queue, sorts the input according to time, and if time_values are same then
      //  person exiting the entrance is given precedence
      std::priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, cmp> pq;
        for (int i = 0; i < n; i++) {
        pq.push(make_tuple(i, arrTime[i], directions[i]));
        }

        vector<int> res(n, 0);
        int prev_direction = -1;
        int time = 0;
        while (!pq.empty()) {
        int idx, second, direction;
        std::tie(idx, second, direction) = pq.top();
        pq.pop();

        if (second != time) prev_direction = -1;

        if (!pq.empty() && get<1>(pq.top()) == second) {
        // If in the previous second the turnstile was used as an entrance,
        // then the customer who wants to enter goes first.
        if ((prev_direction == 0) && (get<2>(pq.top()) == 0)) {
        int a0, b0, c0;
        std::tie(a0, b0, c0) = pq.top(); pq.pop();
        pq.push({idx, second, direction});
        idx = a0; second = b0; direction = c0;
        }
        }
        res[idx] = second;
        prev_direction = direction;
        time = second;

        while (!pq.empty() && get<1>(pq.top()) == second) {
        std::tie(idx, second, direction) = pq.top(); pq.pop();
        pq.push(make_tuple(idx, second+1, direction));
        }
        time++;
        }
        return res;
        }
        };
 */