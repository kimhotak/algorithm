import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<char[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            char commend = tmp.charAt(0);
            if (commend == '3') dq.pollLast();
            else dq.addLast(new char[]{commend, tmp.charAt(2)});
        }

        Deque<Character> result = new ArrayDeque<>();
        while (!dq.isEmpty()) {
            char[] tmp = dq.pollFirst();
            char commend = tmp[0];
            char alphabet = tmp[1];
            if (commend == '1') result.addLast(alphabet);
            else result.addFirst(alphabet);
        }

        if (result.isEmpty()) sb.append(0);
        while (!result.isEmpty()) sb.append(result.pollFirst());
        System.out.print(sb);
    }
}