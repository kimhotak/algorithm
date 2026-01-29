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

    string s;
    cin >> s;
    int joi = 0, ioi = 0;
    for (int i = 0; i <= s.length() - 3; i++) {
        if (s.substr(i, 3) == "JOI") joi++;
        else if (s.substr(i, 3) == "IOI") ioi++;
    }
    cout << joi << '\n' << ioi;

    return 0;
}