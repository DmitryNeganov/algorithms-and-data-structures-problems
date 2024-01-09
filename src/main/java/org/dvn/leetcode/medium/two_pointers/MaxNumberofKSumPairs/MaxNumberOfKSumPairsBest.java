package org.dvn.leetcode.medium.two_pointers.MaxNumberofKSumPairs;

import java.util.HashMap;
import java.util.Map;

//1679
public class MaxNumberOfKSumPairsBest {

    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i: nums) {
            int searchingValue = k - i;
            if (mapa.containsKey(searchingValue)) {
                int quantity = mapa.get(searchingValue);
                if (quantity - 1 == 0) {
                    mapa.remove(searchingValue);
                } else {
                    mapa.replace(searchingValue, quantity, quantity - 1);
                }
                operations++;
            } else {
                if (mapa.containsKey(i)) {
                    mapa.put(i, mapa.get(i) + 1);
                } else {
                    mapa.put(i, 1);
                }

            }
        }
        return operations;
    }
}
