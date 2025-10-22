import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[] leftTop, rightTop;

    public static int[] convert(int y, int x) {
        return new int[]{n+x-y-1, x+y}; // lt, rt
    }

    public static int dfs(int y, int x, int a, int cnt) {
        // 놓을 수 있는 자리 탐색
        while (y < n) {
            if (board[y][x] == 1) {
                int[] convYX = convert(y,x);
                if (!leftTop[convYX[0]] && !rightTop[convYX[1]]) break;
            }
            x += 2;
            if (x >= n) { y++; x = (a+1)%2; a = x;}
        }
        // 탐색 완료
        if (y >= n) return cnt;

        int[] convYX = convert(y,x);
        leftTop[convYX[0]] = true;
        rightTop[convYX[1]] = true;
        x += 2;
        if (x >= n) { y++; x = (a+1)%2; a = x;}
        int placeCase = dfs(y, x, a,cnt+1);
        leftTop[convYX[0]] = false;
        rightTop[convYX[1]] = false;

        // 비숍을 안놓은 경우
        int notPlaceCase = dfs(y, x, a, cnt);

        return Math.max(placeCase, notPlaceCase);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        leftTop = new boolean[2*n-1];
        rightTop = new boolean[2*n-1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = dfs(0,0, 0,0);
        res += dfs(0,1,1,0);
        System.out.print(res);
    }
}