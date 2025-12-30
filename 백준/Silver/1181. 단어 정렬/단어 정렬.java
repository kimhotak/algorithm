import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a,b)->{
            if (a.length() != b.length()) return a.length() - b.length();
            else return a.compareTo(b);
        });

        sb.append(arr[0]).append('\n');
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i-1])) continue;
            sb.append(arr[i]).append('\n');
        }

        System.out.print(sb);
    }
}