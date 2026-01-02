import java.io.*;
import java.util.*;

public class Main {
    static int n, m, res = Integer.MAX_VALUE;
    static int[][] grid;
    static List<int[]> canChoseVirus = new ArrayList<>();
    static Deque<int[]> placedVirus = new ArrayDeque<>();
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static void choseVirus(int idx) {
        if (m == placedVirus.size()) {
            virusSimul();
            return;
        }

        if (idx >= canChoseVirus.size()) return;

        choseVirus(idx+1);

        placedVirus.addLast(canChoseVirus.get(idx));
        choseVirus(idx+1);
        placedVirus.pollLast();
    }

    public static void virusSimul() {
        Deque<int[]> dq = new ArrayDeque<>(placedVirus);
        int[][] dist = new int[n][n];
        int time = 0;

        for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);
        for (int i = 0; i < dq.size(); i++) {
            int[] tmp = dq.pollFirst();
            dist[tmp[0]][tmp[1]] = 0;
            dq.addLast(tmp);
        }
        while (!dq.isEmpty()) {
            time++;
            for (int t = dq.size(); t > 0; t--) {
                int[] c = dq.pollFirst();
                int cr = c[0], cc = c[1];
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i], nc = cc + dc[i];
                    if (nr < 0 || n <= nr || nc < 0 || n <= nc) continue;
                    if (dist[nr][nc] != -1 || grid[nr][nc] == 1) continue;
                    dq.addLast(new int[]{nr,nc});
                    if (grid[nr][nc] == 0) dist[nr][nc] = time;
                    else if (grid[nr][nc] == 2) dist[nr][nc] = 0;
                }
            }
        }

        time = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (dist[r][c] == -1 && grid[r][c] == 0) return;
                if (time < dist[r][c]) time = dist[r][c];
            }
        }

        if (res > time) res = time;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input =  Integer.parseInt(st.nextToken());
                if (input == 2) {
                    canChoseVirus.add(new int[]{i, j});
                }
                grid[i][j] = input;
            }
        }

        choseVirus(0);
        sb.append(res == Integer.MAX_VALUE ? -1 : res);

        System.out.print(sb);
    }
}