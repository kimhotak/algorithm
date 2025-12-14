import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] hyperTube = new int[m][k];
        List<Integer>[] station = new List[n+1];
        for (int i = 1; i <= n; i++) station[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                hyperTube[i][j] = tmp;
                station[tmp].add(i);
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int[] dist = new int[n+1];
        dq.addLast(1);
        dist[1] = 1;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            if (cur == n) break;
            for (int s: station[cur]) {
                for (int next : hyperTube[s]) {
                    if (dist[next] != 0 ||
                        cur == next) continue;
                    dq.addLast(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }

        sb.append(dist[n] == 0 ? -1 : dist[n]);
        System.out.print(sb);
    }
}