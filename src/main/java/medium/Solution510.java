package medium;

public class Solution510 {
    /*
    public Node inorderSuccessor(Node x) {
        // the successor is somewhere lower in the right subtree
        if (x.right != null) {
            x = x.right;
            while (x.left != null) x = x.left;
            return x;
        }

        // the successor is somewhere upper in the tree
        while (x.parent != null && x == x.parent.right) x = x.parent;
        return x.parent;
    }
    */
}
