import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Deque<Long> dq = new ArrayDeque<>();
        dq.addLast(a);

        int cnt = 0;
        boolean isFind = false;
        while (!isFind && !dq.isEmpty()) {
            cnt++;
            Deque<Long> tmp = new ArrayDeque<>();
            while (!dq.isEmpty()) {
                long cur = dq.pollFirst();
                long[] next = {cur * 10 + 1, cur * 2};

                for(long n : next) {
                    if (n < b) {
                        tmp.addLast(n);
                    } else if (n == b) {
                        isFind = true;
                        break;
                    }
                }
            }
            dq = tmp;
        }

        System.out.print(isFind ? cnt+1 : -1);
    }
}