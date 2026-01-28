#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <map>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
#include <utility> // pair가 들어있는 헤더
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        cout << "Distances:";
        string a, b;
        cin >> a >> b;
        for (int i = 0; i < a.length(); i++) {
            int dist = b[i] - a[i];
            cout << ' ' << dist + (dist < 0 ? 26 : 0);
        }
        cout << '\n';
    }

    return 0;
}