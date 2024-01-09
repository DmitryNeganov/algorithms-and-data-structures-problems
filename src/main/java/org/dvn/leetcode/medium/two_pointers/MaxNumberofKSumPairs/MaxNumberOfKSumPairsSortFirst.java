package org.dvn.leetcode.medium.two_pointers.MaxNumberofKSumPairs;

import java.util.Arrays;

//1679
public class MaxNumberOfKSumPairsSortFirst {

    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                operations++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return operations;
    }
}
