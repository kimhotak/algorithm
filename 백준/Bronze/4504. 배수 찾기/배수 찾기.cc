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
    while (true) {
        int num;
        cin >> num;
        if (num == 0) break;
        if (num % n) cout << num << " is NOT a multiple of " << n << ".\n";
        else cout << num << " is a multiple of " << n << ".\n";
    }

    return 0;
}