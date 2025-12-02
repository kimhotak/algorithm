import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return Integer.compare(a, b);
            else return Integer.compare(absA, absB);
        });

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            else pq.add(x);
        }
        System.out.print(sb);
    }
}
