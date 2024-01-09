package org.dvn.leetcode.medium.two_pointers;

//11
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxVol = 0;

        while (left < right) {
            int width = right - left;
            int vol = Math.min(height[left], height[right]) * width;
            if (vol > maxVol) {
                maxVol = vol;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxVol;
    }
}
