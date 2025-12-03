import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String ex = br.readLine().strip();
        int stack = 0;
        int res = 0;
        for (int i = 1; i < ex.length(); i++) {
            if (ex.charAt(i-1) == '(' && ex.charAt(i) == ')') res += stack--;
            else if (ex.charAt(i) == ')'){
                res++;
                stack--;
            }
            else stack++;
        }
        System.out.print(res);
    }
}
