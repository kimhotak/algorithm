import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = n; i > 0; i--) {
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(2 * i - 1)).append('\n');
        }
        System.out.print(sb);
    }
}