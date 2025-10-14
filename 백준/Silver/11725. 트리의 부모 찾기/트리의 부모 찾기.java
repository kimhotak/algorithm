import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        int[] parent = new int[n+1];

        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.addLast(1);
        boolean[] visited = new boolean[n+1];
        visited[0] = true; visited[1] = true;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int next : graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                parent[next] = cur;
                dq.addLast(next);
            }
        }

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
    }
}