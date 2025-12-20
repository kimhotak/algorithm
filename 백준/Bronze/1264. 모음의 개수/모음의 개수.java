import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) break;
            int count = 0;
            for (char c: str.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) count++;
            }
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}