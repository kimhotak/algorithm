
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
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;
        pq.offer(new int[]{x, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] < cur[1]) continue;
            for (int next: graph[cur[0]]) {
                if (dist[next] > dist[cur[0]] + 1) {
                    dist[next] = dist[cur[0]] + 1;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }


        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) res.add(i);
        }
        if (res.size() == 0) sb.append(-1);
        else {
            res.sort((a,b)->a-b);
            for (int i: res) sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}