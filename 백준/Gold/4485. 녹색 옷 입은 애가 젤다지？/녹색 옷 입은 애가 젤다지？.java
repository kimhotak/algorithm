import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static PriorityQueue<int[]> pq;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static int dijkstra() {
        pq.clear();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,grid[0][0]});
        cost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];
            if (cost[r][c] < cur[2]) continue;
            if (r == n-1 && c == n-1) break;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || n <= nc) continue;
                if (cost[nr][nc] <= cost[r][c] + grid[nr][nc]) continue;
                cost[nr][nc] = cost[r][c] + grid[nr][nc];
                pq.offer(new int[]{nr, nc, cost[nr][nc]});
            }
        }

        return cost[n-1][n-1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
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