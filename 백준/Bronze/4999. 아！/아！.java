import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String jea = br.readLine();
        String doc = br.readLine();
        sb.append(doc.length() <= jea.length() ? "go" : "no");

        System.out.println(sb);
    }
}