import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a == b) return;
        else if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int x){
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] candy = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 1; i <= n; i++) find(i);

        Map<Integer,int[]> group = new HashMap<>();
        // [0]: 아이들 수, [1]: 사탕 수
        for (int i = 1; i <= n; i++) {
            if (group.containsKey(parent[i])) {
                group.get(parent[i])[0]++;
                group.get(parent[i])[1] += candy[i];
            }
            else {
                group.put(i, new int[]{1, candy[i]} );
            }
        }

        List<int[]> groupList = new ArrayList<>(group.values());
        int len = groupList.size();


        int[][] dp = new int[len+1][k];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j < k; j++) {
                if (j - groupList.get(i-1)[0] < 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - groupList.get(i-1)[0]] + groupList.get(i-1)[1]);
            }
        }

        System.out.print(dp[len][k-1]);
    }
}