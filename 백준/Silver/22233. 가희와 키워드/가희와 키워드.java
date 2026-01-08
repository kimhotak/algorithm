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

        Set<String> memo = new HashSet<>();
        for (int i = 0; i < n; i++) {
            memo.add(br.readLine());
        }
        
        for (int i = 0; i < m; i++) {
            for (String kw: br.readLine().split(",")) {
                memo.remove(kw);
            }
            sb.append(memo.size()).append('\n');
        }

        System.out.print(sb);
    }
}