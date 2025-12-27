import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        sb.append(7 - (d - f) % 7);

        System.out.print(sb);
    }
}