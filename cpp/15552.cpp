#include <iostream>
#include <chrono>  // 시간 측정 라이브러리
using namespace std;
using namespace chrono;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int t, a, b;
    cin >> t;

    // 실행 시간 측정 시작
    auto start = high_resolution_clock::now();

    for (int i = 0; i < t; i++) {
        cin >> a >> b;
        cout << a + b << '\n';
    }

    // 실행 시간 측정 종료
    auto end = high_resolution_clock::now();
    auto duration = duration_cast<milliseconds>(end - start);  // 밀리초(ms) 단위 변환

    cout << "Execution Time: " << duration.count() << " ms\n";  // 표준 에러(stderr)로 출력

    return 0;
}