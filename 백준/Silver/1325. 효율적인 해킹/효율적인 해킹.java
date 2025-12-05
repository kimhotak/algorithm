import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] head, next, vertex;
    static int edgeCnt;
    static int[] visited;
    static int[] q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        head = new int[n + 1];
        Arrays.fill(head, -1);
        next = new int[m];
        vertex = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vertex[edgeCnt] = a;
            next[edgeCnt] = head[b];
            head[b] = edgeCnt++;
        }

        int[] res = new int[n + 1];
        int max = 0;
        visited = new int[n + 1];
        q = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int front = 0, rear = 0;
            q[rear++] = i;
            visited[i] = i;

            int count = 0;
            while (front < rear) {
                int cur = q[front++];
                for (int e = head[cur]; e != -1; e = next[e]) {
                    int v = vertex[e];
                    if (visited[v] != i) {
                        visited[v] = i;
                        q[rear++] = v;
                        count++;
                    }
                }
            }

            res[i] = count;
            if (count > max) max = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (res[i] == max) sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
}