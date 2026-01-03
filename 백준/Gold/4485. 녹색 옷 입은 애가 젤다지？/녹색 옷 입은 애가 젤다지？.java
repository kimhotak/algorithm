import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, cost;
        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int n;
    static int[][] grid;
    static PriorityQueue<Node> pq;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static int dijkstra() {
        pq.clear();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        pq.offer(new Node(0,0,grid[0][0]));
        cost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cost[cur.r][cur.c] < cur.cost) continue;
            if (cur.r == n-1 && cur.c == n-1) break;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc) continue;
                if (cost[nr][nc] <= cost[cur.r][cur.c] + grid[nr][nc]) continue;
                cost[nr][nc] = cost[cur.r][cur.c] + grid[nr][nc];
                pq.offer(new Node(nr, nc, cost[nr][nc]));
            }
        }

        return cost[n-1][n-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        pq = new PriorityQueue<>();
        int pn = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(pn++).append(": ");
            sb.append(dijkstra()).append('\n');
        }

        System.out.print(sb);
    }
}