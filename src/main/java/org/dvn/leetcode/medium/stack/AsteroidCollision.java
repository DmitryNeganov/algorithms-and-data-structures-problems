package org.dvn.leetcode.medium.stack;

import java.util.LinkedList;

//735
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            int current = asteroids[i];

            while(!stack.isEmpty() && (isTowards(stack.peekLast(), current))) {
                int prev = stack.pollLast();
                int currentWOD = Math.abs(current);
                int prevWOD = Math.abs(prev);
                if (currentWOD < prevWOD) {
                    current = prev;
                } else if (currentWOD == prevWOD) {
                    current = 0;
                    break;
                }
            }
            if (current != 0) {
                stack.add(current);
            }
        }
        int[] result = new int[stack.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = stack.pollFirst();
        }
        return result;
    }

    private boolean isTowards(int aster1, int aster2) {
        if (aster1 < 0 && aster2 > 0) {
            return false;
        } else if (aster1 > 0 && aster2 < 0) {
            return true;
        } else {
            return false;
        }
    }
}
