import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y].add(x);
        }

        boolean[] isBlack = new boolean[n+1];
        int q = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (op == 1) {
                if (isBlack[v]) continue;
                dq.addLast(v);
                isBlack[v] = true;
                while (!dq.isEmpty()) {
                    int cur = dq.pollFirst();
                    for (int next: graph[cur]) {
                        if (isBlack[next]) continue;
                        dq.addLast(next);
                        isBlack[next] = true;
                    }
                }
            }
            else {
                sb.append(isBlack[v] ? "Yes" : "No").append('\n');
            }
        }

        System.out.print(sb);
    }
}