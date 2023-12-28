package org.dvn.leetcode;

//1768
public class MergeStringAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        int word1Length = word1.length();
        int word2Length = word2.length();
        while(counter < word1Length || counter < word2Length) {
            if (counter < word1Length) {
                stringBuilder.append(word1.substring(counter, counter + 1));
            }
            if (counter < word2Length) {
                stringBuilder.append(word2.substring(counter, counter + 1));
            }
            counter++;
        }
        return stringBuilder.toString();
    }
}
