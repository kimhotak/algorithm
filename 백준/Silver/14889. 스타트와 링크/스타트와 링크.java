import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] stat;
    static int[] start, link;
    static int smallDiff = Integer.MAX_VALUE;

    public static void backTrack(int si, int li) {
        if (si + li >= n) {
            int diff = 0;
            for (int i: start) {
                for (int j: start) diff += stat[i][j];
            }
            for (int i: link) {
                for (int j: link) diff -= stat[i][j];
            }
            smallDiff = Math.min(smallDiff, Math.abs(diff));
            return;
        }
        if (si < n/2) {
            start[si] = si + li;
            backTrack(si+1, li);
        }
        if (li < n/2) {
            link[li] = si + li;
            backTrack(si, li+1);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        start = new int[n/2];
        link = new int[n/2];
        
        stat = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTrack(0,0);

        
        sb.append(smallDiff);
        System.out.print(sb);
    }
}