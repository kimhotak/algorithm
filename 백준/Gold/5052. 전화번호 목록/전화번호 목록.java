import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNums = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNums[i] = br.readLine().strip();
            }

            Arrays.sort(phoneNums);

            boolean is1 = true;
            for (int i = 0; i < n-1; i++) {
                if (phoneNums[i+1].startsWith(phoneNums[i])){
                    is1 = false;
                    break;
                }
            }
            sb.append(is1 ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }
}