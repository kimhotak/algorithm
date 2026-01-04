import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append("@".repeat(n * 3)).append(" ".repeat(n)).append("@".repeat(n)).append("\n");
        }
        for (int i = 0; i < 3 * n; i++) {
            sb.append("@".repeat(n)).append(" ".repeat(n)).append("@".repeat(n)).append(" ".repeat(n)).append("@".repeat(n)).append("\n");
        }
        for (int i = 0; i < n; i++) {
            sb.append("@".repeat(n)).append(" ".repeat(n)).append("@".repeat(3 * n)).append("\n");
        }

        System.out.print(sb);
    }
}