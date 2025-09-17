import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                Deque<int[]> dq = new ArrayDeque<>();
                dq.addLast(new int[]{r,c});
                for (int i = 0; i < 3; i++) {
                    Deque<int[]> tdq = new ArrayDeque<>();
                    while (dq) {
                        int[] cur =
                    }
                }
            }
        }
    }
}