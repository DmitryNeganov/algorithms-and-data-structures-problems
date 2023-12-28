package org.dvn.leetcode;


import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatestValue = -1;

        for (int i : candies) {
            if (i > greatestValue) {
                greatestValue = i;
            }
        }

        List<Boolean> result = new ArrayList<>(candies.length);

        for (int i : candies) {
            if ((i + extraCandies) >= greatestValue) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
