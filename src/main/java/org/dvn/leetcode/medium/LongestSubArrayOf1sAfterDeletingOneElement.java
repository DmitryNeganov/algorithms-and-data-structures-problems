package org.dvn.leetcode.medium;

//1493
public class LongestSubArrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int indexToReplace = -1;
        int left = 0;
        int zeros = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
                indexToReplace = right;
            }
            while (zeros > 1 && left < right) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            int length = right - left;
            if (length > maxLength) {
                maxLength = length;
            }
        }
        if (indexToReplace == -1) {
            maxLength = nums.length - 1;
        }
        return maxLength;
    }
}
