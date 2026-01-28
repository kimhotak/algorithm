#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, res = 0;
    cin >> n;
    for (int i = 0; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            res += i + j;
        }
    }
    cout << res;

    return 0;
}