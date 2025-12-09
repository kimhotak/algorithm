import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] tree;
    static int v;
    static int[] dist;

    static int farPoint(int from) {
        Deque<Integer> dq = new ArrayDeque<>();
        dist = new int[v+1];
        int to = from;
        dq.addLast(from);
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int[] tmp: tree[cur]) {
                int next = tmp[0], weight = tmp[1];
                if (dist[next] != 0 || next == from) continue;
                dist[next] = dist[cur] + weight;
                dq.addLast(next);
                if (dist[next] > dist[to]) to = next;
            }
        }
        return to;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());
        tree = new List[v+1];
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            tree[s] = new ArrayList<>();
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[s].add(new int[]{e,w});
            }
        }

        int a = farPoint(1);
        int b = farPoint(a);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[b]);
        System.out.print(sb);
    }
}