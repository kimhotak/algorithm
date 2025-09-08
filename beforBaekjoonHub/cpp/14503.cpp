#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    int r, c, d;
    cin >> r >>> c >> d;
    vector<vector<int>> room(N, vector<int>(M));
    for (int i = 0; i < N; i ++) {
        for (int j = 0; j < M; j++) {
            cin >> room[i][j];
        }
    }

    // 북, 동, 남, 서
    int dr[4] = {-1, 0, 1, 0};
    int dc[4] = {0, 1, 0, -1};

    int cleaned = 0;

    while (true) {
        // 1. 현재 위치 청소
        if (room[r][c] == 0) {
            room[r][c] = 2; // 청소 완료 표시
            cleaned++;
        }

        bool found = false;
        // 2. 네 방향 확인 (왼쪽부터)
        for (int i = 0; i < 4; i++) {
            int nd = (d + 3 - i) % 4; // 왼쪽부터 차례로
            int nr = r + dr[nd];
            int nc = c + dc[nd];
        }

        // 경계 및 청소 여부 확인
        if (room[nr][nc] == 0) {
            r = nr;
            c = nc;
            d = nd;
            found = true;
            break;
        }

        if (!found) {
            // 후진
            int back_d = (d + 2) % 4;
            int br = r + dr[back_d]
            int bc = c + dc[back_d]
            if (room[br][bc] != 1) {
                r = br;
                c = bc;
            }
            else {
                break; // 뒤가 벽이면 종료
            }
        }
    }

    cout << cleaned << '\n';
    return 0;
}