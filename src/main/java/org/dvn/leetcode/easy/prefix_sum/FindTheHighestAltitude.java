package org.dvn.leetcode.easy.prefix_sum;

//1732
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int currentAlt = 0;
        for (int i = 0; i < gain.length; i++) {
            currentAlt += gain[i];
            if (currentAlt > maxAlt) {
                maxAlt = currentAlt;
            }
        }
        return maxAlt;
    }
}
