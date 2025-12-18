import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String id = br.readLine();
         sb.append(":fan::fan::fan:\n");
        sb.append(":fan::").append(id).append("::fan:\n");
        sb.append(":fan::fan::fan:\n");
        
        System.out.println(sb);
    }
}