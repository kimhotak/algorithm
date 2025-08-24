import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] score = new int[n];

            for (int j = 0; j < n; j ++) {
                score[j] = Integer.parseInt(st.nextToken());
            }
            double avg = (double) Arrays.stream(score).sum() / n;

            int cnt = 0;
            for (int j = 0; j < n; j ++) {
                if (score[j] > avg) cnt++;
            }
            sb.append((double) cnt / n * 100).append("%\n");
        }

        System.out.print(sb);
    }
}
