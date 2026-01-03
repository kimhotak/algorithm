import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        sb.append("@".repeat(n+2)).append('\n');
        for (int i = 0; i < n ;i++) {
            sb.append("@");
            sb.append(" ".repeat(n));
            sb.append("@").append('\n');
        }
        sb.append("@".repeat(n+2)).append('\n');

        System.out.print(sb);
    }
}