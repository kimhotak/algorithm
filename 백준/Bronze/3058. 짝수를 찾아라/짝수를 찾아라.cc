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
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int min = INT32_MAX, sum = 0;
        for (int i = 0; i < 7; i++) {
            int num;
            cin >> num;
            if (!(num & 1)) {
                sum += num;
                if (min > num) min = num;
            }
        }
        cout << sum << ' ' << min << '\n';
    }

    return 0;
}