import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String ex = br.readLine().strip();
        int stack = 0;
        int res = 0;
        for (int i = 0; i < ex.length(); i++) {
            if (ex.charAt(i) == ')') {
                stack--;
                if (ex.charAt(i - 1) == '(') res += stack;
                else res++;
            } else stack++;
        }
        System.out.print(res);
    }
}
