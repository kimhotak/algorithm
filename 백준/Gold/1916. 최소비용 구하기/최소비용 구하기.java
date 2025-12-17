import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,w});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1]-b[1]);
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new int[]{s,0});
        cost[s] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cost[cur[0]] < cur[1]) continue;
            if (cur[0] == e) break;
            for (int[] next: graph[cur[0]]) {
                if (cost[next[0]] > cost[cur[0]] + next[1]) {
                    cost[next[0]] = cost[cur[0]] + next[1];
                    pq.offer(new int[]{next[0], cost[next[0]]});
                }
            }
        }
        
        sb.append(cost[e]);
        System.out.print(sb);
    }
}