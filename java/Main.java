import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());

        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i ++) {
            if (indegree[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        int visited = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');
            visited++;
            
            for (int next: graph.get(cur)) {
                if (--indegree[next] == 0){
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}