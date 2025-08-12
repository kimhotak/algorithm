import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] time = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[n + 1];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                indegree[y]++;
            }

            Deque<Integer> dq = new ArrayDeque<>();
            int[] accTime = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    dq.add(i);
                    accTime[i] = time[i];
                }
            }

            while (!dq.isEmpty()) {
                int cur = dq.poll();
                for (int next : graph[cur]) {
                    if (--indegree[next] == 0) {
                        dq.add(next);
                    }
                    accTime[next] = Math.max(accTime[next], accTime[cur] + time[next]);
                }
            }

            int w = Integer.parseInt(br.readLine());
            out.append(accTime[w]).append('\n');
        }
        System.out.println(out.toString());
    }
}