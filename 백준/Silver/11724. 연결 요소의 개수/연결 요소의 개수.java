import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edge = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            edge[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edge[s].add(e);
            edge[e].add(s);
        }

        boolean[] visited = new boolean[n+1];
        visited[0] = true;

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(i);

            while (!q.isEmpty()) {
                int cur = q.pollFirst();
                for (int next: edge[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.addLast(next);
                }
            }
            cnt++;
        }
        System.out.print(cnt);
    }
}