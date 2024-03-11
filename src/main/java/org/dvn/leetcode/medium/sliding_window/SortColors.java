package org.dvn.leetcode.medium.sliding_window;

//75
public class SortColors {
    public void sortColors(int[] nums) {
        int firstRed = 0; //0
        int firstWhite = 0; //1
        int firstBlue = 0; //2

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == 0) {
                nums[i] = nums[firstBlue];
                nums[firstBlue] = nums[firstWhite];
                nums[firstWhite] = current;
                firstWhite++;
                firstBlue++;
            } else if (current == 1) {
                nums[i] = nums[firstBlue];
                nums[firstBlue] = current;
                firstBlue++;
            }
        }

    }
}
