package medium;

/*
You start at index 0 in an array with length 'h'. At each step, you can move to the left,
move to the right, or stay in the same place(Note! Stay in the same place also takes one step).
How many possible ways are you still at index 0 after you have walked 'n' step?

Example： n = 3
1. right->left->stay
2. right->stay->left
3. stay->right->left
4. stay->stay->stay
*/

public class Solution0 {
    int solve(int pos, int steps, int n, int h) {
        if (steps == n && pos == 0) return 1;
        if (steps == n) return 0;
        if (pos >= h || pos < 0) return 0;

        int res = 0;
        res += solve(pos - 1, steps + 1, n, h);
        res += solve(pos, steps + 1, n, h);
        res += solve(pos + 1, steps + 1, n, h);
        return res;
    }
}
