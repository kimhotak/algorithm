import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> days = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            days.add((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int day = 0;
        for (int i = 0; i < days.size(); i++) {
            if (ans.size() == 0 || days.get(i) > day) {
                ans.add(1);
                day = days.get(i);
            }
            else {
                ans.set(ans.size()-1, ans.get(ans.size()-1) + 1);
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}