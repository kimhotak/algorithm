import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int res = 0;
        boolean minus = false;
        for (char s : str.toCharArray()) {
            if (Character.isDigit(s)) sb.append(s);
            else {
                if (minus) res -= Integer.parseInt(sb.toString());
                else res += Integer.parseInt(sb.toString());

                if (s == '-') minus = true;
                sb = new StringBuilder();
            }
        }
        if (minus) res -= Integer.parseInt(sb.toString());
        else res += Integer.parseInt(sb.toString());
        System.out.print(res);

    }
}