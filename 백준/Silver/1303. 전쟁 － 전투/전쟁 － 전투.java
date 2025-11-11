import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static char[][] ground;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};

    public static int dfs(int r, int c, char color) {
        int res = 1;
        ground[r][c] = ' ';
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || m <= nr || nc < 0 || n <= nc ||
                    color != ground[nr][nc]) continue;
            res += dfs(nr, nc, color);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ground = new char[m][];
        for (int i = 0; i < m; i++) {
            ground[i] = br.readLine().toCharArray();
        }

        int blue = 0, white = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ground[i][j] == 'B') blue += (int) Math.pow(dfs(i,j,'B'), 2);
                else if (ground[i][j] == 'W') white += (int) Math.pow(dfs(i,j,'W'), 2);
            }
        }

        sb.append(white).append(' ').append(blue);
        System.out.print(sb);
    }
}