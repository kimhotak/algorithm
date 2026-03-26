import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for (String s: completion) {
            if (map.containsKey(s)) map.replace(s, map.get(s)+1);
            else map.put(s, 1);
        }
        for (String s: participant) {
            if (map.containsKey(s)) {
                if (map.get(s)  == 0) {
                    answer = s;
                    break;
                }
                else {
                    map.replace(s, map.get(s) - 1);
                }
            }
            else {
                answer = s;
                break;
            }
        }
        return answer;
    }
}