import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long a = 0;
        long b = 1;
        for (int i = 1; i < n; i++) {
            b = b + a;
            a = b - a;
        }

        System.out.println(b);
    }
}