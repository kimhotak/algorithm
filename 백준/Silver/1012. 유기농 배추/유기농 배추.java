import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Deque<Point> dq = new ArrayDeque<>();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            int bugCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!map[i][j]) continue;
                    bugCount++;
                    dq.addLast(new Point(i, j));
                    map[i][j] = false;
                    while (!dq.isEmpty()) {
                        Point node = dq.pollFirst();
                        for (int d  = 0; d < 4; d++) {
                            Point next = new Point(node.y + dx[d], node.x + dy[d]);
                            if (0 > next.x || next.x >= m ||
                                0 > next.y || next.y >= n ||
                                !map[next.y][next.x]) continue;
                            map[next.y][next.x] = false;

                            dq.addLast(next);
                        }
                    }
                }
            }
            sb.append(bugCount).append('\n');
        }
        System.out.print(sb);
    }
}

class Point{
    public int x;
    public int y;
    public Point(int y, int x){
        this.x = x;
        this.y = y;
    }
}