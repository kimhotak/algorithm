import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<Integer>();
        Queue<Integer> mpq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty() && mpq.isEmpty()) sb.append(0);
                else if (pq.isEmpty()) sb.append(-mpq.poll());
                else if (mpq.isEmpty()) sb.append(pq.poll());
                else if (pq.peek() < mpq.peek()) sb.append(pq.poll());
                else sb.append(-mpq.poll());
                sb.append('\n');
            }
            else {
                if (x < 0) mpq.add(-x);
                else pq.add(x);
            }
        }
        System.out.print(sb);
    }
}
