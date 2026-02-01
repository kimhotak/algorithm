#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

string solve();

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    deque<int> dq;
    for (int i = 1; i <= n; i++) {
        dq.push_back(i);
    }

    int cnt = 0;
    while (m--) {
        int target;
        cin >> target;
        int idx = 0;
        for (auto it = dq.begin(); it != dq.end(); it++, idx++) {
            if (*it == target) break;
        }
        int left_moves = idx;
        int right_moves = dq.size() - idx;
        if (left_moves <= right_moves) {
            while (left_moves--) {
                int front = dq.front();
                dq.pop_front();
                dq.push_back(front);
                cnt++;
            }
        }
        else {
            while (right_moves--) {
                int back = dq.back();
                dq.pop_back();
                dq.push_front(back);
                cnt++;
            }
        }
		dq.pop_front();
    }
    cout << cnt;

    return 0;
}
