import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int tmp = Integer.parseInt(br.readLine());
            score.add(Math.max(tmp, 40));
        }

        int sum = 0;
        for (int s : score) {
            sum += s;
        }
        System.out.println(sum / 5);
    }
}
