import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int total = l * p;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(x - total).append(" ");
        }

        System.out.print(sb);
    }
}