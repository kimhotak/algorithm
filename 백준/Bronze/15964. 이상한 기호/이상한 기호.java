import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());;
        long b = Long.parseLong(st.nextToken());
        sb.append((a + b) * (a - b));

        System.out.print(sb);
    }
}