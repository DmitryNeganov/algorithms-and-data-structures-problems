package org.dvn.leetcode.easy.binarytree;

//374. Guess Number Higher or Lower
public class GuessNumberHigherorLower {

    public int guess(int num) {
        return 0;
    }
    public int guessNumber(int n) {
        int first = 1, last = n;

        int current = first + (last - first) / 2;
        int result = guess(current);
        while (result != 0) {
            if (result < 0) {
                last = current - 1;
            } else {
                first = current + 1;
            }
            current = first + (last - first) / 2;
            result = guess(current);
        }

        return current;
    }
}
