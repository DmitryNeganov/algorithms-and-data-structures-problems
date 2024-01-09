package org.dvn.leetcode.easy.prefix_sum;

import java.util.Arrays;

//724
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] array = {-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex(array));
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (leftSum < rightSum) {
                leftSum += nums[left];
                left++;
            } else if (leftSum > rightSum) {
                rightSum += nums[right];
                right--;
            } else {
                if (nums[left] < nums[right]) {
                    leftSum += nums[left];
                    left++;
                } else {
                    rightSum += nums[right];
                    right--;
                }
            }
            System.out.println("l = " + left + ", r = " + right);
            System.out.println("ls = " + leftSum + ", rs = " + rightSum);
        }
        if (leftSum != rightSum) return -1;
        return left;
    }
}
