import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph = new List[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] e: edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) dist[i] = -1;
        dist[1] = 0;
        
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int next: graph[cur]) {
                if (dist[next] != -1) continue;
                dq.offerLast(next);
                dist[next] = dist[cur] + 1;
            }
        }
        
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (max == dist[i]) answer++;
        }
        
        return answer;
    }
}