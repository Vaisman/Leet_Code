package easy;

public class Solution463 {
    int check(int[][] grid, int i, int j) {
        int res = 0;
        if (i == 0)
            res+=1;
        else if (grid[i-1][j] == 0)
            res+=1;

        if (i == grid.length-1) {
            res+=1;
        }
        else {
            if (grid[i+1][j] == 0)
                res+=1;
        }

        if (j == 0) {
            res+=1;
        }
        else if (grid[i][j-1] == 0)
            res+=1;

        if (j == grid[i].length-1) {
            res+=1;
        }
        else {
            if (grid[i][j+1] == 0)
                res+=1;
        }
        return res;
    }

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for(int i = 0; i<grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] ==1) {
                    result += check(grid, i, j);
                }
            }
        }
        return result;
    }
}
