import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = st.nextToken().equals("1");
            }
        }

        int resBlue = 0;
        int resWhite = 0;

        Deque<int[]> q = new ArrayDeque<int[]>();
        q.addLast(new int[]{0, 0, n});

        while (!q.isEmpty()) {
            int[] tmp = q.pollFirst();
            int row = tmp[0], col = tmp[1], len = tmp[2];
            boolean color = paper[row][col];

            boolean isSplit = false;
            for (int r = row; r < row + len; r++) {
                for (int c = col; c < col + len; c++){
                    if (paper[r][c] != color){
                        int m = len/2;
                        q.addLast(new int[]{row, col, m});
                        q.addLast(new int[]{row, col + m, m});
                        q.addLast(new int[]{row + m, col, m});
                        q.addLast(new int[]{row + m, col + m, m});
                        isSplit = true;
                        break;
                    }
                }
                if (isSplit) break;
            }
            if (!isSplit) {
                if (color) resBlue++;
                else resWhite++;
            }
        }

        System.out.println(resWhite);
        System.out.print(resBlue);
    }
}