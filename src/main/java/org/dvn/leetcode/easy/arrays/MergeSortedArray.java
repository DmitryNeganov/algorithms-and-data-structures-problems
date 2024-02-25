package org.dvn.leetcode.easy.arrays;

//88
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = nums1.length - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[currentIndex] = nums1[m];
                nums1[m] = 0;
                m--;
            } else {
                nums1[currentIndex] = nums2[n];
                nums2[n] = 0;
                n--;
            }
            currentIndex--;
        }
        while (n >= 0) {
            nums1[currentIndex] = nums2[n];
            nums2[n] = 0;
            n--;
            currentIndex--;
        }
    }
}
