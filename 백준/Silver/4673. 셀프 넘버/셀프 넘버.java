import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isSelf = new boolean[10001];
        Arrays.fill(isSelf, true);
        isSelf[0] = false;

        for (int i = 1; i < 10001; i++) {
            if (!isSelf[i]) continue;
            sb.append(i).append('\n');
            int j = i;
            while (j < 10001 && isSelf[j]) {
                int tmp = j;
                isSelf[j] = false;
                while (tmp > 0) {
                    j += tmp % 10;
                    tmp = tmp / 10;
                }
            }
        }
        System.out.print(sb);
    }
}