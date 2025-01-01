import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] m = new int[n + 1];
        m[0] = 1;
        m[1] = 1;
        for (int i = 2; i <= n; i++) {
            m[i] = (m[i-1] + m[i-2]) % 10007;
        }

        System.out.print(m[n]);
    }
}
