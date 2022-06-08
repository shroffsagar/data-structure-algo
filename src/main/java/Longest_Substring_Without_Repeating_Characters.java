import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return  0;
        if(s.length() == 1) return 1;

        int head = 0, tail = 0;
        char [] chars = s.toCharArray();
        Set<Character> substrChars = new HashSet<Character>();
        int substringLength = 1;
        substrChars.add(chars[head]);
        while(tail < chars.length-1){
            //set head pointer to last occurrence of current head char.
            while(head < chars.length-1 && chars[head+1] == chars[head]){ head++;}
            //if tail is left behind; initialise it to head.
            if(tail < head) tail = head;
            //increment tail-pointer till next char is not in cache.
            while(tail < chars.length-1 && !substrChars.contains(chars[tail+1])){
                tail++;
                substrChars.add(chars[tail]);
            }
            //store the length into result if > existing length
            int currentSubstringLen = (tail-head)+1;
            if(currentSubstringLen > substringLength) substringLength = currentSubstringLen;
            //remove head char
            substrChars.remove(chars[head]);
            //increment head.
            head ++;
        }
        return substringLength;
    }
}
