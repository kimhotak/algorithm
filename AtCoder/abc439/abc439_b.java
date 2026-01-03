import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<Integer> used = new HashSet<>();
        used.add(n);
        String res = "No";
        while (true) {
            if (n == 1) {
                res = "Yes";
                break;
            }

            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = tmp;
            if (used.contains(n)) break;
            used.add(n);
        }
        sb.append(res);

        System.out.print(sb);
    }
}