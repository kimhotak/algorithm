import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        else if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    public static int find(int x) {
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] planet = new int[n][4]; // x, y, z, 행성번호
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
            planet[i][3] = i;
        }
        // 엣지들을 다 표현하면 n^2 / 2 = 50,000,000,000 = 500억
        // int 가 4Byte 이므로 2000억 Byte = 2억 KB = 200,000 MB
        // 아마 시간, 메모리 초과
        // 어떻게 최소화 할 수 있을까
        // 만약 축 하나만 있고 최소화를 한다고 하면 최대 - 최소 일듯
        // 각 3개의 축을 최소화 한 엣지만 넣어두고 최소신장트리
        // 그러면 전체 행성이 연결 안될 일은 없음

        // 인접 리스트 방식으로 표현하면 될듯
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // pq에 {cost, a, b}

        for (int i = 0; i < 3; i++) {
            final int idx = i;
            Arrays.sort(planet, Comparator.comparingInt(a -> a[idx]));
            for (int j = 1; j < n; j++) {
                pq.offer(new int[]{
                        planet[j][i] - planet[j-1][i],
                        planet[j-1][3],
                        planet[j][3]}
                );
            }
        }


        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int res = 0, cnt = 0;

        while (!pq.isEmpty() && cnt < n) {
            int[] tmp = pq.poll();
            int cost = tmp[0], a = tmp[1], b = tmp[2];
            if (union(a, b)){
                // 루트 부모가 다를때, 다른 집합일 때
                res += cost;
                cnt++;
            }
        }

        System.out.print(res);
    }
}