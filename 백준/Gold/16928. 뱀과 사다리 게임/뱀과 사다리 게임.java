import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ladder = new int[100];
        int[] snake = new int[100];
        char[] map = new char[100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            map[s] = 'l';
            ladder[s] = e;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            map[s] = 's';
            snake[s] = e;
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        map[0] = 'v';
        boolean isEnd = false;
        int res = 0;

        while (!isEnd) {
            Deque<Integer> tq = new ArrayDeque<>();
            res++;
            while (!q.isEmpty() && !isEnd) {
                int cur = q.pollFirst();
                boolean goFar = false;
                for (int next = cur + 6; next > cur; next--) {
                    if (next > 99) continue;

                    if (next == 99) {
                        isEnd = true;
                        break;
                    }
                    else if (map[next] == 'l') {
                        if (map[ladder[next]] == 'v') continue;
                        map[ladder[next]] = 'v';
                        tq.addLast(ladder[next]);
                    }
                    else if (map[next] == 's') {
                        if (map[snake[next]] == 'v') continue;
                        map[snake[next]] = 'v';
                        tq.addLast(snake[next]);
                    }
                    else if (!goFar) {
                        if (map[next] == 'v') continue;
                        map[next] = 'v';
                        tq.addLast(next);
                        goFar = true;
                    }
                }
            }
            q = tq;
        }

        System.out.print(res);
    }
}