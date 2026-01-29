#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <map>
#include <set>
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

    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        bool isin[26] = { false };
        for (char c : s) {
            isin[c - 'A'] = true;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (!isin[i]) sum += 'A' + i;
        }
        cout << sum << '\n';
    }
    

    return 0;
}
