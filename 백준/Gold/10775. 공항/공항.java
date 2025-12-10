import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static void union(int n1, int n2){
        int a = find(n1);
        int b = find(n2);
        parent[b] = a;
    }
    static int find(int k){
        if(parent[k] != k){
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        parent = new int[g+1];
        for (int i = 1; i <= g; i++) parent[i] = i;
        int count = 0; // 도킹된 비행기 수

        for (int i = 0; i < p; i++) {
            int gi = Integer.parseInt(br.readLine());

            int emptyGate = find(gi);

            if (emptyGate == 0) {
                break;
            }
            count++;
            union(emptyGate - 1, emptyGate);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        System.out.print(sb);
    }
}