/*
터렛

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	245760	56459	44008	23.179%
문제
조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.



이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

조규현의 좌표
$(x_1, y_1)$와 백승환의 좌표
$(x_2, y_2)$가 주어지고, 조규현이 계산한 류재명과의 거리
$r_1$과 백승환이 계산한 류재명과의 거리
$r_2$가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수
$T$가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

한 줄에 공백으로 구분 된 여섯 정수
$x_1$,
$y_1$,
$r_1$,
$x_2$,
$y_2$,
$r_2$가 주어진다.

출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는
$-1$ 출력한다.

제한
 
$-10\,000 ≤ x_1, y_1, x_2, y_2 ≤ 10\,000$ 
 
$1 ≤ r_1, r_2 ≤ 10\,000$ 
예제 입력 1
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
예제 출력 1
2
1
0
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x2 - x1;
            int dy = y2 - y1;
            int distSq = dx * dx + dy * dy;
            int rSum = r1 + r2;
            int rDiff = Math.abs(r1 - r2);

            if (distSq == 0 && r1 == r2) {
                sb.append(-1).append('\n');
            } else if (distSq > rSum * rSum) {
                sb.append(0).append('\n');
            } else if (distSq < rDiff * rDiff) {
                sb.append(0).append('\n');
            } else if (distSq == rSum * rSum || distSq == rDiff * rDiff) {
                sb.append(1).append('\n');
            } else {
                sb.append(2).append('\n');
            }
        }

        System.out.print(sb);
    }
}