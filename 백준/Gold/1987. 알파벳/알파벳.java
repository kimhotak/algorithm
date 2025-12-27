import java.io.*;
import java.util.*;

public class Main {
    static int r, c, res = 0;
    static char[][] grid;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static Set<Character> visited = new HashSet<>();

    public static void dfs(int cr, int cc) {
        if (visited.size() > res) res = visited.size();

        for (int i = 0; i < 4; i++) {
            int nr = cr + dr[i], nc = cc + dc[i];
            if (nr < 0 || r <= nr ||
                nc < 0 || c <= nc ||
                visited.contains(grid[nr][nc])) continue;
            visited.add(grid[nr][nc]);
            dfs(nr,nc);
            visited.remove(grid[nr][nc]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        visited.add(grid[0][0]);
        dfs(0,0);
        sb.append(res);

        System.out.print(sb);
    }
}