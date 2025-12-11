import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat((2 * n) - (2 * i)));
            sb.append("*".repeat(i)).append('\n');
        }
        for (int i = n - 1; i > 0; i--) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat((2 * n) - (2 * i)));
            sb.append("*".repeat(i)).append('\n');
        }
        System.out.print(sb);
    }
}