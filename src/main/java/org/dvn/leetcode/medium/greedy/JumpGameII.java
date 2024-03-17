package org.dvn.leetcode.medium.greedy;

//45. Jump Game II
public class JumpGameII {
    public int jump(int[] nums) {
        int counter = 0;
        int reachable = 0;
        int currentR = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentR = Math.max(currentR, i + nums[i]);
            if (reachable == i) {
                reachable = currentR;
                counter++;
            }
        }
        return counter;
    }
}
