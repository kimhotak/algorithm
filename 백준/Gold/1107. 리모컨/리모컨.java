import java.io.*;
import java.util.*;

public class Main {
    static int n, res;
    static boolean[] broked;

    public static void dfs(int num, int depth) {
        if (num > 1_000_000) return;
        res = Math.min(res, Math.abs(n-num) + depth);
        for (int i = 0; i < 10; i++) {
            if (broked[i] || (num == 0 && i == 0)) continue;
            dfs(num * 10 + i, depth+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        broked = new boolean[10];
        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broked[Integer.parseInt(st.nextToken())] = true;
            }
        }

        res = Math.abs(n-100);
        for (int i = 0; i < 10; i++) {
            if(broked[i]) continue;
            dfs(i,1);
        }
        sb.append(res);

        System.out.print(sb);
    }
}