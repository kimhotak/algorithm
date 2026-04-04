import java.util.*;
class Solution {
    public int solution(String word) {
        target = word;
        cnt = 0;
        
        dfs("");
        
        return cnt;
    }
    
    static String target;
    static int cnt;
    
    public boolean dfs(String str) {
        if (str.length() != 0) cnt++;
        if (str.equals(target)) return true;
        else if (str.length() == 5) return false;
        
        for (char c: "AEIOU".toCharArray()) {
            if (dfs(str + c)) return true;
        }
        return false;
    }
}