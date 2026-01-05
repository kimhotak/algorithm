import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String g = st.nextToken();
        int gameNum = 3;
        if (g.equals("Y")) gameNum = 1;
        if (g.equals("F")) gameNum = 2;

        Set<String> playing = new HashSet<>();
        while (n-- > 0) {
            playing.add(br.readLine());
        }

        sb.append(playing.size() / gameNum);

        System.out.print(sb);
    }
}