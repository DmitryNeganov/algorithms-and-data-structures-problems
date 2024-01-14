package org.dvn.leetcode.easy.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//933
public class NumberOfRecentCalls {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        List<Integer> list = new ArrayList<>();
        list.add(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        list.add(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        list.add(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        list.add(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3

        System.out.println(list);
    }

    static class RecentCounter {

        LinkedList<Integer> requests;

        public RecentCounter() {
            requests = new LinkedList<>();
        }

        public int ping(int t) {
            requests.add(t);
            int currentFirst = requests.peekFirst();
            while (t - currentFirst > 3000) {
                requests.pollFirst();
                currentFirst = requests.peekFirst();
            }
            return requests.size();
        }
    }
}
