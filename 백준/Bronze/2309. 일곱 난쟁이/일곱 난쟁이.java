import java.io.*;
import java.util.*;

public class Main {

    static int[] h = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int all = 0;
        for (int i = 0; i < 9; i++) {
            h[i] = Integer.parseInt(br.readLine());
            all += h[i];
        }
        Arrays.sort(h);

        int[][] s = new int[9][9];
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < 9; i++) {
            int tmp = all - h[i];
            for (int j = 0; j < 9; j++) {
                if (i != j && tmp - h[j] == 100) {
                    n1 = i;
                    n2 = j;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != n1 && i != n2){
                System.out.println(h[i]);
            }
        }
    }
}
