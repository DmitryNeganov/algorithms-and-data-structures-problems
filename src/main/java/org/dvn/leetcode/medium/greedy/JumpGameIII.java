package org.dvn.leetcode.medium.greedy;

//1306. Jump Game III
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (start > arr.length - 1 || start < 0 || arr[start] == -1) return false;
        if (arr[start] == 0) return true;

        int temp = arr[start];
        arr[start] = -1;

        return canReach(arr, start - temp) || canReach(arr, start + temp);
    }
}
