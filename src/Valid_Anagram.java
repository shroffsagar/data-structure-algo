package src;

import java.util.Arrays;

//https://leetcode.com/problems/valid-anagram/
public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char [] s_chars = s.toCharArray();
        char [] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        return Arrays.equals(s_chars, t_chars);
    }
}
