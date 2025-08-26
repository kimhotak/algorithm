import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String b = br.readLine().strip();
        for (int i = 0; i < b.length(); i++) {
            sb.append(b.charAt(i));
            if (i%10 == 9) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}