import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String str = br.readLine();
            if (str.equals("END")) break;
            StringBuilder reversed = new StringBuilder(str);
            sb.append(reversed.reverse().toString()).append('\n');
        }

        System.out.print(sb);
    }
}