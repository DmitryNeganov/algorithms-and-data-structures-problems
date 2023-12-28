package org.dvn.leetcode;

//151
public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        int sLength = words.length;
        int i = 0;
        int j = sLength - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < sLength - 1; k++) {
            stringBuilder.append(words[k]).append(" ");
        }
        stringBuilder.append(words[sLength - 1]);
        return stringBuilder.toString();
    }
}
