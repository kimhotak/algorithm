import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] line = new int[20];
        int p = Integer.parseInt(br.readLine());
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(' ');
            int stepCount = 0;
            for (int i = 0; i < 20; i++) {
                int in = Integer.parseInt(st.nextToken());
                int idx = i;
                while (0 < idx && in < line[idx-1]) {
                    line[idx] = line[idx-1];
                    stepCount++;
                    idx--;
                }
                line[idx] = in;
            }
            sb.append(stepCount).append('\n');
        }

        System.out.print(sb);
    }
}