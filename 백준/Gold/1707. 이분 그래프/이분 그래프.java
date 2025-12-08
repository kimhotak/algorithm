import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int V, E, u, v, cur;
        List<Integer>[] graph;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] set;

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());;
                v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            set = new int[V+1];
            dq.clear();
            boolean flag = true;

            for (int i = 1; i <= V; i++) {
                if (set[i] != 0) continue;
                dq.addLast(i);
                set[i] = 1;
                while (!dq.isEmpty() && flag) {
                    cur = dq.pollFirst();
                    for (int next: graph[cur]) {
                        if (set[next] == set[cur]) {
                            flag = false;
                            break;
                        }
                        else if (set[next] == 0) {
                            set[next] = 3 - set[cur];
                            dq.addLast(next);
                        }
                    }
                }
                if (!flag) break;
            }

            sb.append(flag ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }
}