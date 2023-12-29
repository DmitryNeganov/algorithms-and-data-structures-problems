package org.dvn.leetcode.medium;

//334
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int middleNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= firstNum) {
                firstNum = nums[i];
            } else if (nums[i] <= middleNum) {
                middleNum = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
