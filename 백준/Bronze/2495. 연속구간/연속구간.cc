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
    
    for (int i = 0; i < 3; i++) {
        string s;
        cin >> s;
        int stric = 1, res = 1;
        for (int j = 1; j < 8; j++) {
            if (s[j] == s[j - 1]) {
                if (++stric > res) res = stric;
            }
            else stric = 1;
        }
        cout << res << '\n';
    }

    return 0;
}
