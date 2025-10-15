import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[f].add(b);
            indegree[b] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) graph[0].add(i);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int next: graph[cur]) {
                if (--indegree[next] > 0) continue;
                dq.addLast(next);
                sb.append(next).append(' ');
            }
        }

        System.out.print(sb);
    }
}