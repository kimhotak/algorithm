import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Character> taka = new HashSet<>();
        for (char c: br.readLine().toCharArray()) {
            taka.add(c);
        }
        Set<Character> aoki = new HashSet<>();
        for (char c: br.readLine().toCharArray()) {
            aoki.add(c);
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            boolean t = true, a = true;
            for (char c: br.readLine().toCharArray()) {
                if (!taka.contains(c)) t = false;
                if (! aoki.contains(c)) a = false;
            }

            if (!t && a) sb.append("Aoki");
            else if (t && !a) sb.append("Takahashi");
            else sb.append("Unknown");
            sb.append('\n');
        }

        System.out.print(sb);
    }
}