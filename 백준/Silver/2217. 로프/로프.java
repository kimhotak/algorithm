import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        int res = 0;

        for (int i = 0; i < n; i++) {
            res = Math.max(res, rope[i] * (n-i));
        }

        System.out.print(res);
    }
}
