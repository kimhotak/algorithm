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

    string n;
    int m;
    cin >> n >> m;
    if (n.length() * stoi(n) < m) {
        for (int i = 0; i < stoi(n); i++) cout << n;
    }
    else {
        int times = m / n.length();
        int etc = m % n.length();
        while (times--) cout << n;
        for (int i = 0; i < etc; i++) {
            cout << n[i];
        }
    }

    return 0;
}