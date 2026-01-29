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

    int n;
    cin >> n;
    cin.ignore();
    for (int i = 1; i <= n; i++) {
        string s;
        getline(cin, s);
        cout << i << ". " << s << '\n';
    }

    return 0;
}
