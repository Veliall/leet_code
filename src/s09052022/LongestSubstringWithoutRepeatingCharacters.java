package s09052022;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String a0 = "dvdf";
        String a1 = "abcabcdbb";
        String a2 = "bbbbb";
        String a3 = "pwwkew";
        String a11 = "abba";

        System.out.println(lengthOfLongestSubstring(a11));
        System.out.println(lengthOfLongestSubstring(a0));
        System.out.println(lengthOfLongestSubstring(a1));
        System.out.println(lengthOfLongestSubstring(a2));
        System.out.println(lengthOfLongestSubstring(a3));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i + 1).contains(String.valueOf(s.charAt(i)))) {
                temp = lengthOf(s.substring(i, s.substring(i + 1).indexOf(s.charAt(i)) + i + 1));
            } else {
                temp = lengthOf(s.substring(i));
            }
            if (temp > max) max = temp;
        }
        return max;
    }

    public static int lengthOf(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int temp = 0;
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) {
                if (temp > max) max = temp;
                temp = 0;
                set.clear();
            }
            temp++;
            set.add(c);
        }
        if (temp > max) max = temp;
        return max;
    }
}
