package src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class Reorder_Data_in_Log_Files {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                StringTokenizer tokenizer1 = new StringTokenizer(s1);
                String id1 = tokenizer1.nextToken(" ");
                String words1 = tokenizer1.nextToken("").trim();
                StringTokenizer tokenizer2 = new StringTokenizer(s2);
                String id2 = tokenizer2.nextToken(" ");
                String words2 = tokenizer2.nextToken("").trim();

                if(!Character.isDigit(words1.charAt(0)) && Character.isDigit(words2.charAt(0)))
                    return -1;
                else if(Character.isDigit(words1.charAt(0)) && !Character.isDigit(words2.charAt(0)))
                    return 1;
                else if(!Character.isDigit(words1.charAt(0)) && !Character.isDigit(words2.charAt(0))){
                    int comparison = words1.compareTo(words2);
                    comparison = (comparison != 0) ? comparison : id1.compareTo(id2);
                    return comparison;
                }
                else return 0;
            }
        };
        Arrays.sort(logs, c);
        return logs;
    }
}
