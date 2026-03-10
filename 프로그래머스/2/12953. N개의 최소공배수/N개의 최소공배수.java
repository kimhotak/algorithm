import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        while (true) {
            boolean flag = true;
            for (int num: arr) {
                if (answer < num || answer % num != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) break;
            answer++;
        }
        return answer;
    }
}