import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100_000_000;

    static class Edge{
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int[] dijkstra(int n, List<Edge>[] graph, int s) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparing(a -> a[0])
        );
        pq.offer(new int[]{0, s}); // 거리, 노드

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int cost = tmp[0], cur = tmp[1];
            if (dist[cur] < cost) continue;

            for (Edge e : graph[cur]) {
                if (cost + e.cost < dist[e.to]) {
                    dist[e.to] = cost + e.cost;
                    pq.offer(new int[]{cost + e.cost, e.to});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Edge>[] road = new ArrayList[n+1];
        List<Edge>[] reverseRoad = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            road[i] = new ArrayList<Edge>();
            reverseRoad[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            road[start].add(new Edge(end, cost));
            reverseRoad[end].add(new Edge(start, cost));
        }

        int[] fx = dijkstra(n, road, x);
        int[] tx = dijkstra(n, reverseRoad, x);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (res < fx[i] + tx[i]) res = fx[i] + tx[i];
        }
        System.out.print(res);
    }
}