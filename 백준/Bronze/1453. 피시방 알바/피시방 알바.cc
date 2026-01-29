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
    bool seat[101];
    for (int i = 0; i < 101; i++) {
        seat[i] = false;
    }

    int ret = 0;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if (seat[x]) ret++;
        else seat[x] = true;
    }

    cout << ret;

    return 0;
}