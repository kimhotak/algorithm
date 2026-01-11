import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int firstMax = -1;
        int lastMax = 0;

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > arr[lastMax]) {
                firstMax = i;
                lastMax = i;
            }
            else if (arr[i] == arr[lastMax]) {
                lastMax = i;
            }
        }

        int res = 0;
        int top = 0;
        for (int i = 0; i < firstMax; i++) {
            if (arr[i] <= top) {
                res += top - arr[i];
            }
            else {
                top = arr[i];
            }
        }

        for (int i = firstMax; i < lastMax; i++) {
            res += arr[lastMax] - arr[i];
        }

        top = 0;
        for (int i = w-1; i > lastMax; i--) {
            if (arr[i] <= top) {
                res += top - arr[i];
            }
            else {
                top = arr[i];
            }
        }

        sb.append(res);


        System.out.print(sb);
    }
}