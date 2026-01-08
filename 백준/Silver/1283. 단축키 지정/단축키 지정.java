import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Set<Character> quick = new HashSet<>();
        while (n-- > 0) {
            String str = br.readLine();
            boolean registed = false;
            int q = -1;

            for (int i = 0; i < str.length(); i++) {
                if (!quick.contains(Character.toLowerCase(str.charAt(i))) &&
                        (i == 0 || str.charAt(i-1) == ' ')) {
                    quick.add(Character.toLowerCase(str.charAt(i)));
                    registed = true;
                    q = i;
                    break;
                }
            }

            if (!registed) {
                for (int i = 0; i < str.length(); i++) {
                    if (!quick.contains(Character.toLowerCase(str.charAt(i))) &&
                        str.charAt(i) != ' ') {
                        quick.add(Character.toLowerCase(str.charAt(i)));
                        q = i;
                        break;
                    }
                }
            }

            for (int i = 0; i < str.length(); i++) {
                if (i == q) sb.append('[').append(str.charAt(i)).append(']');
                else sb.append(str.charAt(i));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}