package medium;

public class Solution427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        }
    }

    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node helper(int[][] grid, int x, int y, int len) {
        if(len == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }

        Node nodeTL = helper(grid, x, y, len/2);
        Node nodeTR = helper(grid, x, y+len/2, len/2);
        Node nodeBL = helper(grid, x+len/2, y, len/2);
        Node nodeBR = helper(grid, x+len/2, y+len/2, len/2);

        // Merge all child nodes
        if(nodeTL.isLeaf && nodeTR.isLeaf && nodeBL.isLeaf && nodeBR.isLeaf) {
            if(nodeTL.val && nodeTR.val && nodeBL.val && nodeBR.val) {
                return new Node(true, true, null, null, null, null);
            }
            if(!nodeTL.val && !nodeTR.val && !nodeBL.val && !nodeBR.val)  {
                return new Node(false, true, null, null, null, null);
            }
        }

        return new Node(true, false, nodeTL, nodeTR, nodeBL, nodeBR);
    }
}
