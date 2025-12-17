import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return true;
        parent[ry] = rx;
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int res = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (union(a,b)) {
                res = i;
                break;
            }
        }

        sb.append(res);
        System.out.print(sb);
    }
}