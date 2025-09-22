import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        f(new ArrayDeque<Integer>());
    }

    static int n;
    static int m;
    static int[] arr;
    static Set<String> res = new HashSet<>();

    static void f(Deque<Integer> dq) {
        if (dq.size() == m) {
            StringBuilder tmp = new StringBuilder();
            for (int n : dq) {
                tmp.append(arr[n]).append(' ');
            }
            if (!res.contains(tmp.toString())) {
                res.add(tmp.toString());
                System.out.println(tmp);
            }
        }

        for (int i = 0; i < n; i++) {
            if (dq.contains(i)) continue;
            dq.addLast(i);
            f(dq);
            dq.pollLast();
        }
    }
}