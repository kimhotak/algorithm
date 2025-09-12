import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
             c = (b + 2 * a) % 10007;
             a = b;
             b = c;
        }
        System.out.print(c);
    }
}