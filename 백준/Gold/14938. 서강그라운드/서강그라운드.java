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
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,l});
            graph[b].add(new int[]{a,l});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist = new int[n+1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.offer(new int[]{i,0});
            dist[i] = 0;

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (dist[cur[0]] < cur[1]) continue;
                for (int[] next: graph[cur[0]]) {
                    if (dist[next[0]] > dist[cur[0]] + next[1]) {
                        dist[next[0]] = dist[cur[0]] + next[1];
                        pq.offer(new int[]{next[0], dist[next[0]]});
                    }
                }
            }

            int item = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[j] <= m) {
                    item += items[j];
                }
            }
            res = Math.max(res, item);
        }

        sb.append(res);
        System.out.print(sb);
    }
}