import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k1 = 0, k2 = 0;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if (tmp.equals("KBS1")) k1 = i;
            else if (tmp.equals("KBS2")) k2 = i;
        }

        if (k2 < k1) k2++;
        sb.append("1".repeat(k1)).append("4".repeat(k1));
        sb.append("1".repeat(k2)).append("4".repeat(k2-1));

        System.out.print(sb);
    }
}