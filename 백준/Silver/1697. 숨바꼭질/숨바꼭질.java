import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int time = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.addLast(n);
        boolean[] visited = new boolean[200001];

        while (true) {
            Deque<Integer> tmp = new ArrayDeque<Integer>();
            while (!q.isEmpty()) {
                int pos = q.pollFirst();
                if (pos > 200000 || pos < 0 || visited[pos]) continue;
                if (pos == k) {
                    System.out.print(time);
                    return;
                }
                visited[pos] = true;
                tmp.addLast(pos + 1);
                tmp.addLast(pos - 1);
                tmp.addLast(pos * 2);
            }
            q = tmp;
            time++;
        }
    }
}