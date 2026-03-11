import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for (int num: arr) {
            answer = lcm(answer, num);
        }
        return answer;
    }
    
    public int lcm(int x, int y) {
        return x / gcd(x, y) * y;
    }
    
    public int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}