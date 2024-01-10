package org.dvn.leetcode.easy.prefix_sum;

import java.util.Arrays;

//724
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] array = {-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex(array));
    }

    public static int pivotIndex(int[] nums) {
        int fullSum = 0;
        for (int i = 0; i < nums.length; i++) {
            fullSum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((leftSum * 2) == (fullSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
