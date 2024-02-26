package org.dvn.leetcode.easy.array_string;

//169
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int element = -1;
        int counter = 0;

        for (int i : nums) {
            if (counter == 0) {
                element = i;
                counter++;
            } else if (element == i) {
                counter++;
            } else {
                counter--;
            }
        }
        return element;
    }
}
