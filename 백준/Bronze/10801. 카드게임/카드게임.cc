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

    int aw = 0, bw = 0;
    vector<int> a(10);
    for (int i = 0; i < 10; i++) cin >> a[i];
    vector<int> b(10);
    for (int i = 0; i < 10; i++) cin >> b[i];

    for (int i = 0; i < 10; i++) {
        if (a[i] > b[i]) aw++;
        else if (a[i] < b[i]) bw++;
    }

    if (aw == bw) cout << 'D';
    else if (aw > bw) cout << 'A';
    else cout << 'B';

    return 0;
}
