import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        double allScore = 0;
        double allTime = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double time = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            allTime += time;
            if (grade.equals("F")) continue;

            double score = (int)'E' - (int)grade.charAt(0);
            if (grade.charAt(1) == '+') score += 0.5;
            allScore += score * time;
        }

        sb.append(allScore / allTime);
        System.out.print(sb);
    }
}