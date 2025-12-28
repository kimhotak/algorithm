import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]>[] tree;

    public static int[] farestPoint(int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        pq.offer(new int[]{x,0});
        cost[x] = 0;

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (cost[c[0]] < c[1]) continue;
            for (int[] n: tree[c[0]]) {
                if (cost[n[0]] > cost[c[0]] + n[1]) {
                    cost[n[0]] = cost[c[0]] + n[1];
                    pq.offer(new int[]{n[0], cost[n[0]]});
                }
            }
        }
        int farCost = 0, farPoint = 0;
        for (int i = 0; i < n; i++) {
            if (cost[i] > farCost) {
                farCost = cost[i];
                farPoint = i;
            }
        }

        return new int[] {farPoint, farCost};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<int[]>();
        for (int i = 0; i < n - 1; i ++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            tree[p].add(new int[]{c,w});
            tree[c].add(new int[]{p,w});
        }

        int[] farFromRoot = farestPoint(0);
        int[] farFromFar = farestPoint(farFromRoot[0]);
        sb.append(farFromFar[1]);

        System.out.print(sb);
    }
}