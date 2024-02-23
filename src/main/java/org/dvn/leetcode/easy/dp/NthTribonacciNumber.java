package org.dvn.leetcode.easy.dp;

import java.util.ArrayList;
import java.util.List;

//1137
public class NthTribonacciNumber {
    List<Integer> list = new ArrayList<>();

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        fillList(n);
        return list.get(n - 1) + list.get(n - 2) + list.get(n - 3);
    }

    private void fillList(int n) {
        list.add(0);
        list.add(1);
        list.add(1);
        for (int i = 2; i < n; i++) {
            list.add(list.get(i) + list.get(i - 1) + list.get(i - 2));
        }
    }
}
