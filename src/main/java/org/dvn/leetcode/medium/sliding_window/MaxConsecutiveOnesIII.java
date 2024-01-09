package org.dvn.leetcode.medium.sliding_window;

//1004
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxWindowWithKZeros = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            int window = right - (left - 1);
            if (maxWindowWithKZeros < window) {
                maxWindowWithKZeros = window;
            }
        }
        return maxWindowWithKZeros;
    }
}


