package src;

public class Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.isEmpty() && s2.isEmpty()) return true;
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        //create map of characters and their occurrence.
        int [] c1CharOccurrences = new int[26];
        for(char c : c1){
            c1CharOccurrences[c-'a'] = c1CharOccurrences[c-'a'] + 1;
        }
        int head = 0, tail = 0;
        while(tail < c2.length){
            int [] cloneC1CharOccurrences = c1CharOccurrences.clone();
            //move head till character exists in map.
            while(head < c2.length && cloneC1CharOccurrences[c2[head]-'a']==0) {
                head ++;
            }
            tail = head;
            int charMatchCount = 0;
            //move tail till characters exists in map
            while(tail < c2.length)
            {
                int occurrence = cloneC1CharOccurrences[c2[tail]-'a'];
                if(occurrence <=0) break;
                charMatchCount++;
                //return true if we have found our substring
                if(charMatchCount == c1.length) return true;
                cloneC1CharOccurrences[c2[tail]-'a'] = occurrence-1;
                tail ++;
            }
            head++;
        }
        return false;
    }

    //Tests
    public static void main(String[] args) {
        Permutation_in_String p = new Permutation_in_String();
        if (!p.checkInclusion("abc", "abmccbac") ) throw new RuntimeException("expected true");
        if (!p.checkInclusion("c", "abcabc") ) throw new RuntimeException("expected true");
        if (!p.checkInclusion("", "") ) throw new RuntimeException("expected true");
        if (!p.checkInclusion("adc", "dcda") ) throw new RuntimeException("expected true");
        if (!p.checkInclusion("adc", "dcda") ) throw new RuntimeException("expected true");
        if (p.checkInclusion("abc", "azbcxc") ) throw new RuntimeException("expected false");
        if (p.checkInclusion("abcd", "abc") ) throw new RuntimeException("expected false");
        if (p.checkInclusion("", "abzdc") ) throw new RuntimeException("expected false");
        if (p.checkInclusion("abcd", "") ) throw new RuntimeException("expected false");

    }

}
