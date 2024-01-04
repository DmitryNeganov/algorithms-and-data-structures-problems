package org.dvn.leetcode.medium.MaxNumberofKSumPairs;

//1679
public class MaxNumberOfKSumPairsBruteForce {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) continue;
                if ((nums[i] + nums[j]) == k) {
                    nums[i] = 0;
                    nums[j] = 0;
                    operations++;
                    break;
                }
            }
        }
        return operations;
    }
}
