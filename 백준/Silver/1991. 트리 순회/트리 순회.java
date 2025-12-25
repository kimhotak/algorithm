import java.io.*;
import java.util.*;

public class Main {
    static int[] left, right;
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void bfs(int node) {
        if (node < 0) return;
        pre.append((char)('A' + node));
        bfs(left[node]);
        in.append((char)('A' + node));
        bfs(right[node]);
        post.append((char)('A' + node));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        left = new int[n];
        right = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            left[root] = st.nextToken().charAt(0) - 'A';
            right[root] = st.nextToken().charAt(0) - 'A';
        }

        bfs(0);

        sb.append(pre.toString()).append('\n');
        sb.append(in.toString()).append('\n');
        sb.append(post.toString()).append('\n');
        System.out.print(sb);
    }
}