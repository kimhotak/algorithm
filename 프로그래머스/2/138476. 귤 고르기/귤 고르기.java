import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer,Integer> counter = new HashMap<>();
        for (int t: tangerine) {
            counter.put(t,counter.getOrDefault(t,0) + 1);
        }
        
        ArrayList<Integer> counted = new ArrayList<>(counter.values());
        counted.sort(Collections.reverseOrder());
        
        int boxed = 0;
        for (int i: counted) {
            boxed += i;
            answer++;
            if (boxed >= k) break;
        }
        
        return answer;
    }
}