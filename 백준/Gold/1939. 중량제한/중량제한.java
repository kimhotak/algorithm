import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) parent[rootX] = rootY;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[2]-a[2]);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] bridge = new int[3];
            for (int j = 0; j < 3; j++) {
                bridge[j] = Integer.parseInt(st.nextToken());
            }
            pq.offer(bridge);
        }

        st = new StringTokenizer(br.readLine());
        int f1 = Integer.parseInt(st.nextToken());
        int f2 = Integer.parseInt(st.nextToken());
        int weight = 0;
        
        while (find(f1) != find(f2)) {
            int[] tmp = pq.poll();
            int a = tmp[0], b = tmp[1];
            weight = tmp[2];
            union(a, b);
            while (!pq.isEmpty() && pq.peek()[2] == weight) {
                tmp = pq.poll();
                a = tmp[0];
                b = tmp[1];
                union(a, b);
            }
        }
        
        sb.append(weight);
        System.out.print(sb);
    }
}