import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int nn = n*n;
        int[][] arr = new int[4][n]; // a b c d
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[nn];
        int[] cd = new int[nn];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i*n+j] = arr[0][i] + arr[1][j];
                cd[i*n+j] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int abi = 0, cdi = nn-1;
        long res = 0;
        while (abi < nn && cdi >= 0) {
            if (ab[abi] + cd[cdi] == 0) {
                int abti = abi;
                while (abi < nn && ab[abti] == ab[abi]) abi++;
                int cdti = cdi;
                while (cdi >= 0 && cd[cdti] == cd[cdi]) cdi--;
                res += ((long)abi - abti) * ((long)cdti - cdi);
            }
            else if (ab[abi] + cd[cdi] < 0) abi++;
            else cdi--;
        }

        System.out.print(res);
        // 256,000,000,000,000까지 나올 수 있음
    }
}