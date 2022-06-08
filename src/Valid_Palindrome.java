package src;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/valid-palindrome/
public class Valid_Palindrome {
    private boolean isAlphaNumeric(char c){
        int asciiCode = (int) c;
        return (asciiCode >= 48 && asciiCode <=57)
                || (asciiCode >=65 && asciiCode <=90)
                || (asciiCode >=97 && asciiCode <=122);
    }

    //1 loop + 2-pointer
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char [] chars = s.toCharArray();
        int head = 0;
        int tail = s.length()-1;
        while(head<=tail){
            char cHead = chars[head];
            char cTail = chars[tail];
            if(!isAlphaNumeric(cHead)){
                head ++;
            }
            if(!isAlphaNumeric(cTail)){
                tail --;
            }
            if(!isAlphaNumeric(cHead) || !isAlphaNumeric(cTail))
                continue;
            else {
                if(cHead != cTail) return false;
                else {
                    head ++;
                    tail --;
                }
            }
        }
        return true;
    }

    //2 loop + 2 pointer
    public boolean isPalindrome2(String str) {
        str = str.toLowerCase();
        List<Character> alphaNumericChars = new ArrayList<>();
        for(char c: str.toCharArray()){
            if(isAlphaNumeric(c)){
                alphaNumericChars.add(c);
            }
        }
        int e=alphaNumericChars.size()-1;
        for(int s=0; s<(e+1); s++){
            char c1 = alphaNumericChars.get(s);
            char c2 = alphaNumericChars.get(e);
            if(c1 != c2) return false;
            e--;
        }
        return true;
    }
}
