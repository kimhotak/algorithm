import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int r, c;

    public static int find(int a, int b) {
        int x = a * c + b;
        if (parent[x] == x) return x;
        parent[x] = find(parent[x] / c, parent[x] % c);
        return parent[x];
    }

    public static void union(int xr, int xc, int yr, int yc) {
        int rootX = find(xr, xc);
        int rootY = find(yr, yc);
        if (rootX != rootY) parent[rootY] = rootX;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        parent = new int[r * c + c];
        for (int i = 0; i < r * c + c; i++) parent[i] = i;

        char[][] lake = new char[r][c];
        for (int i = 0; i < r; i++) lake[i] = br.readLine().toCharArray();

        int[][] swan = new int[2][2];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (lake[i][j] != 'L') continue;
                swan[idx++] = new int[] {i, j};
                lake[i][j] = '.';
            }
        }

        Deque<int[]> iceDeque = new ArrayDeque<>();
        Deque<int[]> waterDeque = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j] || lake[i][j] == 'X') continue;
                waterDeque.addLast(new int[]{i ,j});

                while (!waterDeque.isEmpty()) {
                    int[] cur = waterDeque.pollFirst();
                    int cr = cur[0], cc = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int nr = cr + dr[k];
                        int nc = cc + dc[k];
                        if (nr < 0 || r <= nr ||
                                nc < 0 || c <= nc||
                                visited[nr][nc]) continue;

                        if (lake[nr][nc] == 'X') {
                            iceDeque.addLast(new int[]{nr,nc});
                        }
                        else if (lake[nr][nc] == '.') {
                            waterDeque.addLast(new int[]{nr,nc});
                            union(i, j, nr, nc);
                        }
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        int time = 0;
        while (find(swan[0][0], swan[0][1]) != find(swan[1][0], swan[1][1])) {
            time++;
            for (int i = iceDeque.size(); i > 0; i--) {
                int[] cur = iceDeque.pollFirst();
                int cr = cur[0], cc = cur[1];
                for (int k = 0; k < 4; k++) {
                    int nr = cr + dr[k];
                    int nc = cc + dc[k];
                    if (nr < 0 || r <= nr ||
                            nc < 0 || c <= nc) continue;

                    if (lake[nr][nc] == 'X' && !visited[nr][nc]) {
                        iceDeque.addLast(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                    else if (lake[nr][nc] == '.') {
                        union(nr, nc, cr, cc);
                    }
                }
                lake[cr][cc] = '.';
            }
        }

        sb.append(time);
        System.out.print(sb);
    }
}