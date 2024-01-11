package org.dvn.leetcode.easy.hashmap_set;

import java.util.*;

//2215
public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        System.out.println(findDifference(nums1, nums2));
    }


    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> both = new ArrayList<>();
        Set<Integer> answer0 = new HashSet<>();
        Set<Integer> answer1 = new HashSet<>();

        for (int i = 0; i < nums1Length; i++) {
            if (!isThere(nums2, nums1[i])) {
                answer0.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2Length; i++) {
            if (!isThere(nums1, nums2[i])) {
                    answer1.add(nums2[i]);
            }
        }

        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>(answer0));
        answers.add(new ArrayList<>(answer1));

        return answers;
    }

    private static boolean isThere(int[] nums, int number) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int current = left + (right - left) / 2;
            if (nums[current] == number) {
                return true;
            } else if (nums[current] > number) {
                right = current - 1;
            } else {
                left = current + 1;
            }
        }
        return false;
    }
}
