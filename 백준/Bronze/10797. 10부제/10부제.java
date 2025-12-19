import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int d = Integer.parseInt(br.readLine()) % 10;

        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            if (d == Integer.parseInt(st.nextToken())) res++;
        }
        sb.append(res);
        
        System.out.print(sb);
    }
}