package medium;

import common.TreeNode;

import java.util.Stack;

public class Solution1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // if either of the tree is empty
        if (root1 == null || root2 == null)
            return false;

        // stack 'stack1' used for the inorde traversal of root 1
        // stack 'stack2' used for the reverse inorder traversal of root 2
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode t1, t2;

        while (true) {
            // LeftMost Node.
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            // RighMost Node.
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.right;
            }
            // If either is empty then break.
            if (stack1.empty() || stack2.empty())
                break;

            t1 = stack1.peek();
            t2 = stack2.peek();

            // if the sum of the node's is equal to 'target'
            if ((t1.val + t2.val) == target) {
                return true;
            }

            // move to next possible node in the inorder traversal of root 1
            else if ((t1.val + t2.val) < target) {
                stack1.pop();
                root1 = t1.right;
            }

            // move to next possible node in the reverse inorder traversal of root 2
            else {
                stack2.pop();
                root2 = t2.left;
            }
        }

        return false;
    }

    ////////////
    public boolean twoSumBSTs1(TreeNode root1, TreeNode root2, int target) {
        return find2BST(root1,root2,target);
    }

    private boolean findBST(TreeNode root, int value){
        if(root == null){
            return false;
        }
        if(root.val == value){
            return true;
        }
        else if(root.val < value){
            return findBST(root.right,value);
        }
        else{
            return findBST(root.left,value);
        }
    }

    private boolean find2BST(TreeNode root1, TreeNode root2, int target){
        if(root1 == null){
            return false;
        }

        return (findBST(root2,target - root1.val)
                || find2BST(root1.left, root2, target)
                || find2BST(root1.right, root2, target));
    }
}
