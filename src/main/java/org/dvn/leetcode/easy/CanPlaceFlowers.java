package org.dvn.leetcode.easy;

//605
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        if (length == 1) return flowerbed[0] == 0 ? n <= 1 : n == 0;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }


        for (int i = 1; i < length - 1; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        if (flowerbed[length - 1] == 0 && flowerbed[length - 2] == 0) {
            flowerbed[length - 1] = 1;
            n--;
        }

        return n <= 0;
    }
}
