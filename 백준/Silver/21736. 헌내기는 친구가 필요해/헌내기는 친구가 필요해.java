import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] campus = new char[n][m];
        int[] now = new int[]{};
        for (int r = 0; r < n; r++) {
            campus[r] = br.readLine().toCharArray();
            for (int c = 0; c < m; c++) {
                if (campus[r][c] == 'I'){
                    now = new int[]{r, c};
                    campus[r][c] = 'X';
                }
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(now);
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
        int res = 0;

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || n <= nr ||
                    nc < 0 || m <= nc ||
                    campus[nr][nc] == 'X') continue;

                if (campus[nr][nc] == 'P') res++;
                campus[nr][nc] = 'X';
                q.addLast(new int[]{nr,nc});
            }
        }

        System.out.print(res == 0 ? "TT" : res);
    }
}