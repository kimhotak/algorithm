import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> arr = new ArrayList<>(set);
        arr.sort((a,b)->{
            if (a.length() != b.length()) return a.length() - b.length();
            else return a.compareTo(b);
        });

        for (String s: arr) sb.append(s).append('\n');

        System.out.print(sb);
    }
}