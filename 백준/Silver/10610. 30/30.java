import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] n = br.readLine().strip().toCharArray();
        int sum = 0;
        boolean has0 = false;
        for (char c : n) {
            if (c == '0') has0 = true;
            sum += c - '0';
        }

        if (sum % 3 == 0 && has0){
            Arrays.sort(n);
            for (int i = n.length - 1; i >= 0; i--) sb.append(n[i]);
        }
        else {
            sb.append(-1);
        }
        System.out.print(sb);
    }
}