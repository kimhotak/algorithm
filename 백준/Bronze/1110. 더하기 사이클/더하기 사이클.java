import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = n;
        int cnt = 0;
        do {
            m = (m % 10) * 10 + ((m / 10) + (m % 10)) % 10;
            cnt++;
        } while (n != m);
        System.out.print(cnt);
    }
}
