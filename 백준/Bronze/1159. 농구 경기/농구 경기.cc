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
#include <numeric> // gcd, lcm이 들어있는 헤더#include <string>
#include <sstream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int s[26] = { 0 };
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        s[str[0] - 'a']++;
    }

    bool flag = true;
    for (int i = 0; i < 26; i++) {
        if (s[i] >= 5) {
            cout << (char)('a' + i);
            flag = false;
        }
    }

    if (flag) cout << "PREDAJA";



    return 0;
}
