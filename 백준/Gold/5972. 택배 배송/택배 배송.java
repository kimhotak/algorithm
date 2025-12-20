import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new int[]{1,0});
        cost[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cost[cur[0]] > cur[1]) continue;
            if (cur[0] == n) break;
            for (int[] next: graph[cur[0]]) {
                if (cost[next[0]] > cost[cur[0]] + next[1]) {
                    cost[next[0]] = cost[cur[0]] + next[1];
                    pq.offer(new int[]{next[0], cost[next[0]]});
                }
            }
        }

        sb.append(cost[n]);
        System.out.print(sb);
    }
}