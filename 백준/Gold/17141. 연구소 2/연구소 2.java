import java.io.*;
import java.util.*;

public class Main {
    static int n, m, res = Integer.MAX_VALUE;
    static int emptyBlockCnt = 0;
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
        boolean[][] visited = new boolean[n][n];
        int virused = 0;
        for (int i = 0; i < dq.size(); i++) {
            int[] tmp = dq.pollFirst();
            visited[tmp[0]][tmp[1]] = true;
            virused++;
            dq.addLast(tmp);
        }

        int time = -1;
        while (!dq.isEmpty()) {
            time++;
            for (int t = dq.size(); t > 0; t--) {
                int[] c = dq.pollFirst();
                int cr = c[0], cc = c[1];
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i], nc = cc + dc[i];
                    if (nr < 0 || n <= nr ||
                            nc < 0 || n <= nc ||
                            visited[nr][nc] ||
                            grid[nr][nc] == 1) continue;
                    dq.addLast(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    virused++;
                }
            }
        }

        if (virused == emptyBlockCnt) {
            res = Math.min(res, time);
        }
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
                    input = 0;
                }
                if (input == 0) emptyBlockCnt++;
                grid[i][j] = input;
            }
        }

        choseVirus(0);
        sb.append(res == Integer.MAX_VALUE ? -1 : res);

        System.out.print(sb);
    }
}