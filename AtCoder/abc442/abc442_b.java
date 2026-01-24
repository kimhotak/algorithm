import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());
        int v = 0;
        boolean isPlay = false;

        for (int i = 0; i < q; i++) {
            int op = Integer.parseInt(br.readLine());
            if (op == 1) v++;
            else if (op == 2 && v != 0) v--;
            else if (op == 3) isPlay = !isPlay;
            
            if (isPlay && v >= 3) sb.append("Yes\n");
            else sb.append("No\n");
        }

        System.out.print(sb);
    }
}