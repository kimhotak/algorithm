import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int s = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            b = b + s;
            s = b - s;
        }
        System.out.println(b);
    }
}