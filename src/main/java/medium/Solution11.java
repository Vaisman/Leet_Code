package medium;

public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0; int right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h*(right-left);
            if (area > maxArea) maxArea = area;

            if (height[left] < height[right]) {
                int curr = height[left];
                while (left < right && height[left] <= curr) ++left;
            }
            else if (height[left] > height[right]) {
                int curr = height[right];
                while (left < right && height[right] <= curr) --right;
            }
            else {
                int curr = height[left];
                while (left < right && height[left] <= curr) ++left;
                while (left < right && height[right] <= curr) --right;
            }
        }

        return maxArea;
    }
}
