package org.dvn.leetcode.easy;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == 0) {
                while (nums[right] == 0) {
                    right++;
                    if (right == nums.length) {
                        return;
                    }
                }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
            left++;
            right++;
        }
    }
}
