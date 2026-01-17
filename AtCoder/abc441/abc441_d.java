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
        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,c});
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{1,0});

        int level = 0;
        int node = dq.size();
        boolean[] res = new boolean[n+1];
        while (!dq.isEmpty() && level <= l) {

            int[] cur = dq.pollFirst();
            for (int[] next: graph[cur[0]]) {
                int cost = cur[1] + next[1];
                if (level == l-1) {
                    if (s <= cost && cost <= t) {
                        res[next[0]] = true;
                    }
                }
                else {
                    dq.addLast(new int[]{next[0], cost});
                }
            }

            if (--node == 0) {
                node = dq.size();
                level++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (res[i]) sb.append(i).append(' ');
        }

        System.out.print(sb);
    }
}