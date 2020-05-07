package hard;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution315 {
    /*
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            out.add(count);
        }
        return out;
    }
    */

        class SegTreeNode {
            int min;
            int max;
            int count;
            SegTreeNode left;
            SegTreeNode right;

            public int mid() {
                return ((max + 1 - min) / 2 + min);
            }

            public SegTreeNode(int min, int max) {
                this.min = min;
                this.max = max;
                count = 0;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> list = new LinkedList<>();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i : nums) {
                min = min > i ? i : min;
                max = max < i ? i : max;
            }

            SegTreeNode root = new SegTreeNode(min, max);

            for (int i = nums.length - 1; i >= 0; i--) {
                list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
                add(nums[i], root);
            }

            return list;
        }

        private int find(int x, SegTreeNode root) {
            if (root == null) return 0;

            if (x >= root.max) {
                return root.count;
            } else {
                int mid = root.mid();
                if (x < mid) {
                    return find(x, root.left);
                } else {
                    return find(x, root.left) + find(x, root.right);
                }
            }
        }

        private void add(int x, SegTreeNode root) {
            if (x < root.min || x > root.max) return;

            root.count++;
            if (root.max == root.min) return;

            int mid = root.mid();
            if (x < mid) {
                if (root.left == null) {
                    root.left = new SegTreeNode(root.min, mid - 1);
                }
                add(x, root.left);
            } else {
                if (root.right == null) {
                    root.right = new SegTreeNode(mid, root.max);
                }
                add(x, root.right);
            }
        }

        @Test
        public void test() {
            countSmaller(new int[]{5,2,6,1});
        }
}
