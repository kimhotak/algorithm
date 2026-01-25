import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            boolean isEnd = true;
            visited = new boolean[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (visited[r][c]) continue;
                    toChange.clear();
                    int[] res = new int[2];
                    getUnionCnt(r, c, res);
                    if (res[1] > 1) {
                        isEnd = false;
                        int value = res[0]/res[1];
                        for (int[] a: toChange) {
                            arr[a[0]][a[1]] = value;
                        }
                    }
                }
            }
            if (isEnd) break;
            day++;
        }
        sb.append(day);

        System.out.print(sb);
    }

    static int n, L, R;
    static int[] dr = {0,0,-1,1}, dc = {-1,1,0,0};
    static int[][] arr;
    static boolean[][] visited;
    static List<int[]> toChange = new ArrayList<>();

    public static void getUnionCnt(int r, int c, int[] res) {
        // res [0] : 인구수의 합 [1] : 칸의 개수
        visited[r][c] = true;
        toChange.add(new int[]{r,c});
        res[0] += arr[r][c];
        res[1]++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || n <= nr || nc < 0 || n <= nc) continue;
            int diff = Math.abs(arr[r][c] - arr[nr][nc]);
            if (diff < L || R < diff || visited[nr][nc]) continue;
            getUnionCnt(nr, nc, res);
        }
    }

}