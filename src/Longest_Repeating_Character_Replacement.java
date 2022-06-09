package src;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/
class Longest_Repeating_Character_Replacement
{
    private int mostRepeatingChars(Map<Character, Integer> occurrences) {
        int maxValue = 0;
        for(int i : occurrences.values()){ if( i > maxValue) maxValue = i; }
        return maxValue;
    }

    //SOLUTION-1 sliding window algorithm
    public int characterReplacement(String s, int k) {
        if(s == null || s.isEmpty()) return 0;

        char [] chars = s.toCharArray();
        int head = 0, tail = -1;
        int maxSubstringLength = 0;
        Map<Character, Integer> occurrences = new HashMap<>();
        while(tail < chars.length-1){
            tail ++;
            int count = occurrences.getOrDefault(chars[tail],0);
            occurrences.put(chars[tail], ++count);
            int lengthOfCurrentSubstring = (tail-head)+1;
            if(lengthOfCurrentSubstring - mostRepeatingChars(occurrences) <= k){
                maxSubstringLength = (lengthOfCurrentSubstring > maxSubstringLength) ? lengthOfCurrentSubstring : maxSubstringLength;
            }
            else {
                int c = occurrences.get(chars[head]);
                c -= 1;
                occurrences.put(chars[head], c);
                head ++;
            }
        }
        return maxSubstringLength;
    }

    //SOLUTION-2  o(n^2)
    public int characterReplacement2(String s, int k) {
        int maxsubstringLen = 0;
        for(int i=0; i < s.length(); i++){
            int r =0;
            int substringLen = 1;
            for(int j=i+1; j < s.length();j++){
                if(s.charAt(j) != s.charAt(i)) r++;
                if(r>k) break;
                substringLen++;
            }
            if(maxsubstringLen < substringLen) maxsubstringLen = substringLen;
        }
        return maxsubstringLen;
    }

    public static void main(String[] args) {
        int r = new Longest_Repeating_Character_Replacement().characterReplacement("AABABBA", 1);
        System.out.println(r);
    }
}