import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        comb(0,0,n/2,a);
        comb(0,n/2,n,b);
        Collections.sort(a);
        Collections.sort(b);

        long res = 0;
        int ai = 0, bi = b.size()-1;
        while (ai < a.size() && bi >= 0) {
            int sum = a.get(ai) + b.get(bi);
            if (sum == s) {
                int acnt = 0;
                int bcnt = 0;
                int aval = a.get(ai), bval = b.get(bi);
                while (ai < a.size() && a.get(ai) == aval) {
                    ai++;
                    acnt++;
                }
                while (bi >= 0 && b.get(bi) == bval) {
                    bi--;
                    bcnt++;
                }
                res += (long) acnt * bcnt;
            }
            else if (sum > s) bi--;
            else ai++;
        }

        sb.append(res + ((s == 0) ? -1 : 0));

        System.out.print(sb);
    }

    static int[] arr;

    public static void comb(int sum, int idx, int end, List<Integer> retList){
        if (idx == end) {
            retList.add(sum);
            return;
        }
        comb(sum, idx+1, end, retList);
        comb(sum + arr[idx], idx+1, end, retList);
    }
}