import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int onWeight = 0, idx = 0;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offerLast(0);
        }
        
        while (idx < truck_weights.length) {
            answer++;
            onWeight -= bridge.pollFirst();
            
            if (onWeight + truck_weights[idx] <= weight) {
                onWeight += truck_weights[idx];
                bridge.offerLast(truck_weights[idx++]);
            }
            else {
                bridge.offerLast(0);                
            }
        }
        return answer + bridge_length;
    }
}