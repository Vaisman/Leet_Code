package medium;

import org.junit.Test;

import java.util.Stack;

public class Solution255 {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> inorder = new Stack<>();

        for(int v : preorder){
            if(!inorder.isEmpty() && v < inorder.peek())
                return false;
            while(!stack.isEmpty() && v > stack.peek()){
                inorder.push(stack.pop());
            }
            stack.push(v);
        }
        return true;
    }

    public boolean verifyPreorder2(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }

    public boolean verifyPreorder1(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }

    @Test
    public void test() {
        verifyPreorder2(new int[]{5,2,1,3,6});
    }
}
