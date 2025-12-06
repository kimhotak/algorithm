import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] volcano = new int[v][3];
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            volcano[i][0] = Integer.parseInt(st.nextToken())-1;
            volcano[i][1] = Integer.parseInt(st.nextToken())-1;
            volcano[i][2] = Integer.parseInt(st.nextToken());
            grid[volcano[i][0]][volcano[i][1]] = -2;
        }
        Arrays.sort(volcano, Comparator.comparingInt(a -> a[2]));


        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        Deque<int[]> vdq = new ArrayDeque<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{y,x});
        boolean[][] visited = new boolean[m][n];
        visited[y][x] = true;
        int time = 0;
        int vi = 0;
        int highest = grid[y][x];
        int shortTime = 0;

        // 0초에 분화한 화산
        // 화산 분화
        while (vi < volcano.length && volcano[vi][2] == time) {
            vdq.addLast(new int[]{volcano[vi][0],volcano[vi][1]});
            vi++;
        }


        while (!dq.isEmpty()) {
            time++;

            // 화산 번짐
            for (int i = vdq.size(); i > 0; i--) {
                int[] tmp = vdq.pollFirst();
                int cy = tmp[0], cx = tmp[1];
                for (int k = 0; k < 4; k++) {
                    int ny = cy + dy[k], nx = cx + dx[k];
                    if (ny < 0 || m <= ny || nx < 0 || n <= nx ||
                            grid[ny][nx] == -1) continue;
                    grid[ny][nx] = -1;
                    vdq.addLast(new int[]{ny,nx});
                }
            }

            // 화산 분화
            while (vi < volcano.length && volcano[vi][2] == time) {
                vdq.addLast(new int[]{volcano[vi][0],volcano[vi][1]});
                vi++;
            }

            for (int i = dq.size(); i > 0; i--) {
                int[] tmp = dq.pollFirst();
                int cy = tmp[0], cx = tmp[1];
                for (int k = 0; k < 4; k++) {
                    int ny = cy + dy[k], nx = cx + dx[k];
                    if (ny < 0 || m <= ny || nx < 0 || n <= nx ||
                            grid[ny][nx] < 0 || visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    dq.addLast(new int[]{ny,nx});
                    if (grid[ny][nx] > highest) {
                        highest = grid[ny][nx];
                        shortTime = time;
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(highest).append(' ').append(shortTime);
        System.out.print(sb);
    }
}