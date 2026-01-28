#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        int time = 0;
        double score = 0;
        for (int i = 0; i < n; i++) {
            int t;
            double s;
            cin >> t >> s;
            time += t;
            score += s * t;
        }
        cout << fixed << setprecision(1);
        cout << time << ' ' << score / time << '\n';
    }

    return 0;
}