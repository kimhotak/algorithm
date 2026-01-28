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

    vector<int> w(10), k(10);
    for (int i = 0; i < 10; i++) cin >> w[i];
    for (int i = 0; i < 10; i++) cin >> k[i];

    sort(w.begin(), w.end());
    sort(k.begin(), k.end());

    int ws = 0, ks = 0;
    for (int i = 7; i < 10; i++) {
        ws += w[i];
        ks += k[i];
    }

    cout << ws << ' ' << ks;

    return 0;
}