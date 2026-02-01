#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

string solve();

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    //freopen("input.txt", "r", stdin);

    int t;
    cin >> t;
    while (t--) {
        pair<int, int > x, y;
		cin >> x.first >> x.second >> y.first >> y.second;
        int n;
        cin >> n;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            pair<int, int> c;
            int r;
            cin >> c.first >> c.second >> r;
            
			bool inx = ((x.first - c.first) * (x.first - c.first) + (x.second - c.second) * (x.second - c.second)) < r * r;
			bool iny = ((y.first - c.first) * (y.first - c.first) + (y.second - c.second) * (y.second - c.second)) < r * r;
            if (inx ^ iny) cnt++;
        }

        cout << cnt << '\n';
    }

    return 0;
}
