import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int e = Integer.parseInt(st.nextToken()) - 1;

        List<Integer>[] tp = new List[n];
        for (int i = 0; i < n; i++) tp[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            tp[x].add(y);
            tp[y].add(x);
        }

        int[] map = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(s);
        dist[s] = 0;
        int[] dArr = {-1, 1};

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            if (cur == e) break;
            // walk
            for (int d: dArr) {
                int next = cur + d;
                if (next < 0 || n <= next ||
                    dist[next] != -1) continue;
                dq.addLast(next);
                dist[next] = dist[cur] + 1;
            }

            //tp
            for (int next: tp[cur]) {
                if (dist[next] != -1) continue;
                dq.addLast(next);
                dist[next] = dist[cur] + 1;
            }
        }

        sb.append(dist[e]);
        System.out.print(sb);
    }
}