import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];
        // 지나갈 수 없으면 false

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine().strip();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) == '1';
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Point> Q = new ArrayDeque<>();
        Q.add(new Point(0, 0));
        map[0][0] = false;
        int res = 1;

        while (!Q.isEmpty()) {
            Deque<Point> tmpQ = new ArrayDeque<>();
            res += 1;
            while (!Q.isEmpty()) {
                Point node = Q.pollFirst();
                for (int i = 0; i < 4; i++) {
                    Point next = new Point(node.x + dx[i], node.y + dy[i]);

                    if (next.x < 0 || next.x >= m ||
                            next.y < 0 || next.y >= n ||
                            !map[next.y][next.x]) continue;

                    if (next.x == m-1 && next.y == n-1){
                        System.out.println(res);
                        return;
                    }

                    tmpQ.add(next);
                    map[next.y][next.x] = false;
                }
            }
            Q = tmpQ;
        }

    }

    public static class Point {
        public int x;
        public int y;

        public Point(int i, int j) {
            x = i;
            y = j;
        }
    }
}
