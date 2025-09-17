import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (0 < t--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            StringBuilder[] l = new StringBuilder[10000];

            Deque<Integer> q = new ArrayDeque<Integer>();
            q.addLast(a);
            l[a] = new StringBuilder();

            int cur = -1;
            boolean isEnd = false;
            while (!isEnd) {
                cur = q.pollFirst();
                int[] di = new int[4];
                int next;
                for (char op : new char[]{'D', 'S', 'L', 'R'}) {
                    if (op == 'D') next = (cur * 2) % 10000;
                    else if (op == 'S') next = cur == 0 ? 9999 : cur - 1;
                    else if (op == 'L') next = (cur % 1000) * 10 + (cur / 1000);
                    else next = (cur % 10) * 1000 + (cur / 10);

                    if (l[next] != null || next == a) continue;
                    l[next] = new StringBuilder(l[cur]).append(op);
                    if (next == b) {
                        isEnd = true;
                        break;
                    }
                    q.addLast(next);
                }
            }

            sb.append(l[b]).append('\n');
        }
        System.out.print(sb);
    }
}