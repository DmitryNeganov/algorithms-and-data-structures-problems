package org.dvn.leetcode.medium.array_string;

//80
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 2 || nums[i] != nums[count - 2]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
