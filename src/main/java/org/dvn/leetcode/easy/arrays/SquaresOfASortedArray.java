package org.dvn.leetcode.easy.arrays;

//977
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (index >= 0) {
            int rightNum = nums[right] * nums[right];
            int leftNum = nums[left] * nums[left];
            if (rightNum > leftNum) {
                result[index] = rightNum;
                right--;
            } else {
                result[index] = leftNum;
                left++;
            }
            index--;
        }

        return result;
    }
}
