import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Integer::compare);
        }

        boolean[] visited = new boolean[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;
            visited[node] = true;
            sb.append(node).append(' ');
            for (int i = graph[node].size()-1; i >= 0; i--) {
                stack.push(graph[node].get(i));
            }
        }

        sb.append('\n');

        visited = new boolean[n + 1];
        visited[v] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);


        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(' ');
            for (int next : graph[node]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }

        System.out.print(sb);



    }
}