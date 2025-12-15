import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String,String> parent;
    static HashMap<String,Integer> size;

    public static String find(String x) {
        if (parent.get(x) == x) return x;
        parent.replace(x, find(parent.get(x)));
        return parent.get(x);
    }

    public static int union(String x, String y) {
        // 사이즈 반환
        parent.putIfAbsent(x,x);
        size.putIfAbsent(x,1);
        String rootX = find(x);
        
        parent.putIfAbsent(y,y);
        size.putIfAbsent(y,1);
        String rootY = find(y);
        
        if (rootX != rootY) {
            parent.replace(rootX, parent.get(rootY));
            size.replace(rootY, size.get(rootY) + size.get(rootX));
        }
        return size.get(rootY);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            parent = new HashMap<>();
            size = new HashMap<>();
            int f = Integer.parseInt(br.readLine());
            while (f-- > 0) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                sb.append(union(a, b)).append('\n');
            }
        }
        
        
        System.out.print(sb);
    }
}