package medium;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque();
        List<Integer> output = new ArrayList();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            // update both stacks
            // by going left till possible
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            // Add the smallest value into output,
            // pop it from the stack,
            // and then do one step right
            if (stack2.isEmpty() || !stack1.isEmpty() && stack1.getFirst().val <= stack2.getFirst().val) {
                root1 = stack1.pop();
                output.add(root1.val);
                root1 = root1.right;
            }
            else {
                root2 = stack2.pop();
                output.add(root2.val);
                root2 = root2.right;
            }
        }
        return output;
    }
}