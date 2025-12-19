import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int cook = Integer.parseInt(br.readLine());
        cook += s + m * 60 + h * 60 * 60;
        s = cook % 60;
        cook /= 60;
        m = cook % 60;
        cook /= 60;
        h =  cook % 24;
        sb.append(h).append(' ').append(m).append(' ').append(s);
        
        System.out.print(sb);
    }
}