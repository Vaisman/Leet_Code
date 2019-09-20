package easy;

import org.junit.Test;

import common.TreeNode;

public class Solution530 {

    long minDiff = Long.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return (int)minDiff;
    }

    private void helper(TreeNode curr, long lb, long rb){
        if(curr==null) return;
        if(lb!=Long.MIN_VALUE){
            minDiff = Math.min(minDiff,curr.val - lb);
        }
        if(rb!=Long.MAX_VALUE){
            minDiff = Math.min(minDiff,rb - curr.val);
        }
        helper(curr.left,lb,curr.val);
        helper(curr.right,curr.val,rb);
    }


    @Test
    public void test() {
        TreeNode node = new TreeNode(236);
        node.left = new TreeNode(104);
        node.right = new TreeNode(701);
        node.left.right = new TreeNode(227);
        node.left.right.right = new TreeNode(229);
        node.left.right.right.right = new TreeNode(233);
        node.left.right.right.left = new TreeNode(228);

        node.right.right = new TreeNode(911);

        getMinimumDifference(node);
    }
}

/*
           236,
     104,       701,
  null, 227,  null, 911
           229
         228  233
 */
