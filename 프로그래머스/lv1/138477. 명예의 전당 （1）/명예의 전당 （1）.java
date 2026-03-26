import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
            if (pq.size() > k) {
                pq.poll();
            }
            answer.add(pq.peek());
        }
        System.out.print(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}