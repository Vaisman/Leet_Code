package easy;

import common.TreeNode;

public class Solution606 {
    private void rec(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null ) {
                sb.append("(");
                rec(t.left, sb);
                sb.append(")");

                if (t.right != null) {
                    sb.append("(");
                    rec(t.right, sb);
                    sb.append(")");
                }
            }
        }
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        rec(t, sb);
        return sb.toString();
    }
}
