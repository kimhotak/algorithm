import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] pageSize = new int[n+1];
        for (int i = 1; i <= n ;i++) {
            pageSize[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> back = new ArrayDeque<>();
        Deque<Integer> front = new ArrayDeque<>();
        int now = 0;
        int cache = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if (op == 'B' && !back.isEmpty() && now != 0) {
                front.addLast(now);
                now = back.pollLast();
            }
            else if (op == 'F' && !front.isEmpty() && now != 0) {
                back.addLast(now);
                now = front.pollLast();
            }
            else if (op == 'A') {
                while (!front.isEmpty()) cache -= pageSize[front.pollLast()];
                if (now != 0) back.addLast(now);
                now = Integer.parseInt(st.nextToken());
                cache += pageSize[now];
                while (cache > c && !back.isEmpty()) cache -= pageSize[back.pollFirst()];
            }
            else if (op == 'C') {
                Deque<Integer> tmp = new ArrayDeque<>();
                while (!back.isEmpty()) {
                    int p = back.pollFirst();
                    if (tmp.isEmpty() || p != tmp.peekLast()) tmp.addLast(p);
                    else cache -= pageSize[p];
                }
                back = tmp;
            }
        }
        sb.append(now).append('\n');

        if (back.isEmpty()) sb.append(-1);
        while (!back.isEmpty()) sb.append(back.pollLast()).append(' ');
        sb.append('\n');

        if (front.isEmpty()) sb.append(-1);
        while (!front.isEmpty()) sb.append(front.pollLast()).append(' ');

        System.out.print(sb);
    }
}