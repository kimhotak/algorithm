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
        map<int, bool> is_seat;
        int p, m, cant_seat = 0;
        cin >> p >> m;
        for (int i = 0; i < p; i++) {
            int c;
            cin >> c;
            if (is_seat[c]) cant_seat++;
            else is_seat[c] = true;
        }
        cout << cant_seat << '\n';
    }

    return 0;
}