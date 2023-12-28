package org.dvn.leetcode.medium;

//238
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int numsSize = nums.length;
        int[] result = new int[numsSize];

        result[0] = 1;
        for (int i = 1; i < numsSize; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suf = 1;
        for (int j = numsSize - 1; j >= 0; j--) {
            result[j] *= suf;
            suf *= nums[j];
        }
        return result;
    }
}
