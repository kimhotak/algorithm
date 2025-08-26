import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] month = {0, 31,28,31,30,31, 30,31,31,30,31, 30,31};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < x; i++) {
            y += month[i];
        }
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(day[y%7]);
    }
}