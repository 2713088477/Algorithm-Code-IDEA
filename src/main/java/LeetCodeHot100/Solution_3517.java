package LeetCodeHot100;

import java.util.Arrays;

public class Solution_3517 {
    public String smallestPalindrome(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        char[] sortChars = Arrays.copyOf(chars, length / 2);
        Arrays.sort(sortChars);
        StringBuilder builder = new StringBuilder(String.valueOf(sortChars));
        if (length % 2 != 0) {
            builder.append(chars[(length - 1) / 2]);
        }
        for (int len = sortChars.length - 1; len >= 0; len--) {
            builder.append(sortChars[len]);
        }
        return builder.toString();
    }
}
