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

    string s;
    while (getline(cin, s)) {
        int low = 0, big = 0, num = 0, empty = 0;
        for (char c : s) {
            if (islower(c)) low++;
            if (isupper(c)) big++;
            if ('0' <= c && c <= '9') num++;
            if (c == ' ') empty++;
        }

        cout << low << ' ' << big << ' ' << num << ' ' << empty << '\n';
    }

    return 0;
}