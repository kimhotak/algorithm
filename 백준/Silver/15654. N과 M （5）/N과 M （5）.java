import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int n;
    static int m;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        f(new ArrayList<Integer>());
        System.out.print(sb);
    }

    static void f(List<Integer> list) {
        if (list.size() >= m){
            for(int l : list)
                sb.append(l).append(' ');
            sb.append('\n');
            return;
        }
        for (int i : arr) {
            if (list.contains(i)) continue;
            list.add(i);
            f(list);
            list.remove(list.size() -1 );
        }
    }
}