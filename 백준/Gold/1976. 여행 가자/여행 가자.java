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
        if (rootX == rootY) return;
        parent[rootX] = rootY;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (i > j && st.nextToken().equals("1")) {
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int setNum = find(Integer.parseInt(st.nextToken()) - 1);
        String res = "YES";
        for (int i = 1; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken()) - 1;
            if (setNum != find(tmp)) {
                res = "NO";
                break;
            }
        }
        sb.append(res);
        System.out.print(sb);
    }
}