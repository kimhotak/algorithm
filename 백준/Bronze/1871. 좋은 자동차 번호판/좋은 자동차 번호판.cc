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
#include <math.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    while (n-- > 0) {
        string s;
        cin >> s;
        int a = 0, b;
        b = stoi(s.substr(4, 4));
        for (int i = 0; i < 3; i++) {
            a += (s[i] - 'A') * pow(26, 2 - i);
        }

        if (abs(a - b) > 100) cout << "not ";
        cout << "nice\n";
    }

    return 0;
}