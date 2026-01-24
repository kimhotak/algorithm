import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            res.clear();
            stack = new int[n];
            stack[0] = 1;
            top = 1;
            dfs(2);
            Collections.sort(res);
            for (String s: res) sb.append(s).append('\n');
            sb.append('\n');
        }



        System.out.print(sb);
    }

    static int n;
    static List<String> res = new ArrayList<>();
    static int[] stack;
    static int top;

    public static void dfs(int depth) {
        if (depth > n) {
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            int sum = 0;
            for (int i = 0; i < top; i++) {
                sum += stack[i];
            }
            if (sum != 0) return;

            for (int i = 0; i < top; i++) {
                if (stack[i] > 0) sb.append('+');
                sb.append(i);
            }

            res.add(sb.toString());
            return;
        }
        // +
        stack[top++] = depth;
        dfs(depth + 1);
        top--;

        // -
        stack[top++] = -depth;
        dfs(depth + 1);
        top--;

        // 합치기
        stack[top-1] = stack[top] * 10 + depth;
        dfs(depth + 1);

    }
}