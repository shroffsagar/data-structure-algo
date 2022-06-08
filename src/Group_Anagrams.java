package src;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/group-anagrams/
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();
        for(String s : strs){
            String sortedString = getSortedString(s);
            List<String> anagrams = table.get(sortedString);
            anagrams = (anagrams == null) ? new ArrayList<>() : anagrams;
            anagrams.add(s);
            table.put(sortedString, anagrams);
        }
        return table.values().stream().collect(Collectors.toList());
    }

    private String getSortedString(String s) {
        char [] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
