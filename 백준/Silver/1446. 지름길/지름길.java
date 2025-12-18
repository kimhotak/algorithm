
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        int[][] path = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            path[i][0] = Integer.parseInt(st.nextToken());
            path[i][1] = Integer.parseInt(st.nextToken());
            path[i][2] = Integer.parseInt(st.nextToken());
            
        }

        Arrays.sort(path,(a,b)-> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });
        
        int[] dist = new int[d+1];
        for (int i = 0; i <= d; i++) dist[i] = i;
            
        for (int[] p: path) {
            int u = p[0], v = p[1], w = p[2];
            for (int j = 0; j <= d - v; j++) {
                if (v+j > d) continue;
                if (dist[v+j] > dist[u] + w + j) {
                    dist[v+j] = dist[u] + w + j;
                }
            }
        }
        
        sb.append(dist[d]);
        System.out.print(sb);
    }
}