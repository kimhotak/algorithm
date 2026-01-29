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
#include <numeric> // gcd, lcm이 들어있는 헤더
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    bool rm[26] = { false };
    for (char c : "CAMBRIDGE") {
        rm[c - 'A'] = true;
    }

    string s;
    cin >> s;

    for (char c : s) {
        if (!rm[c - 'A']) cout << c;
    }

    return 0;
}
