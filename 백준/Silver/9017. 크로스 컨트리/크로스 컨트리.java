import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int m = 0;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                m = Math.max(m, arr[i]);
            }

            int[] memCnt = new int[m+1];
            int[][] teams = new int[m+1][6];

            for (int i = 0; i < n; i++) {
                teams[arr[i]][memCnt[arr[i]]++] = i;
            }

            int[] scores = new int[m+1];
            int score = 1;
            for (int i = 0; i < n; i++) {
                if (memCnt[arr[i]] < 6) {
                    scores[arr[i]] = Integer.MAX_VALUE;
                    continue;
                }
                if (memCnt[arr[i]] < 10) scores[arr[i]] += score;
                memCnt[arr[i]]++;
                score++;
            }

            int res = 1;
            for (int i = 2; i <= m; i++) {
                if (memCnt[i] < 6) continue;
                if (scores[i] < scores[res]) res = i;
                else if (scores[i] == scores[res] && teams[i][4] < teams[res][4]) res = i;
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}