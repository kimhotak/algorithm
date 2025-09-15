import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        char[][] arrRB = new char[n][n];

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.toCharArray();
            arrRB[i] = tmp.replace('G', 'R').toCharArray();
        }
        sb.append(bfs(arr,n)).append(' ').append(bfs(arrRB,n));
        System.out.print(sb);
    }

    static int bfs(char[][] a, int n) {
        int res = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (a[r][c] == 'V') continue;
                res++;

                q.addLast(new int[]{r,c});
                char color = a[r][c];
                a[r][c] = 'V';

                while (!q.isEmpty()) {
                    int[] tmp = q.pollLast();
                    int cr = tmp[0], cc = tmp[1];
                    for (int i = 0; i < 4; i++) {
                        int nr = cr + dr[i], nc = cc + dc[i];
                        if (nr < 0 || n <= nr ||
                            nc < 0 || n <= nc ||
                            a[nr][nc] == 'V' ||
                            a[nr][nc] != color) continue;

                        a[nr][nc] = 'V';
                        q.addLast(new int[]{nr,nc});
                    }
                }
            }
        }

        return res;
    }
}