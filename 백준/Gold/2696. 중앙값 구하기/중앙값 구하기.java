import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        PriorityQueue<Integer> big = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>((a,b)->b-a);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int n = (m-1)/2 +1;
            int[] res = new int[n];
            int idx = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                // 일단 큰쪽에 넣음
                big.offer(Integer.parseInt(st.nextToken()));
                // 작은쪽에서 가장 큰게 큰쪽에서 가장 작은 것보다 크면 교환
                if (!small.isEmpty() && small.peek() > big.peek()) {
                    big.offer(small.poll());
                    small.offer(big.poll());
                }
                if ((i&1) == 1) res[idx++] = big.peek();
                else small.offer(big.poll());
            }

            big.clear();
            small.clear();
            // 출력
            sb.append(n);
            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) sb.append('\n');
                sb.append(res[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}