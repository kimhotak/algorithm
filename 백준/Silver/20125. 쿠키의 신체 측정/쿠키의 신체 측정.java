import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] grid;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}; // 상 하 좌 우
    public static int length(int sr, int sc, int d) {
        int cnt = 0;
        while (0 <= sr && sr < n && 0 <= sc && sc < n &&
                grid[sr][sc] == '*') {
            cnt++;
            sr += dr[d];
            sc += dc[d];
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new char[n][];
        for (int i = 0; i < n ; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int hr = 0, hc = 0;
        out:
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    hr = i+1;
                    hc = j;
                    sb.append(hr+1).append(' ').append(hc+1).append('\n');
                    break out;
                }
            }
        }

        sb.append(length(hr,hc-1,2)).append(' '); // 왼팔
        sb.append(length(hr,hc+1,3)).append(' '); // 오른팔

        int backLen = length(hr + 1,hc,1);
        sb.append(backLen).append(' '); // 허리

        sb.append(length(hr + backLen + 1,hc - 1,1)).append(' '); // 왼다리
        sb.append(length(hr + backLen + 1,hc + 1,1)); // 오른다리

        System.out.print(sb);
    }
}