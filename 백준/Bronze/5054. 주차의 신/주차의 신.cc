#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <map>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int max = 0, min = INT32_MAX;
        while (n--) {
            int num;
            cin >> num;
            if (max < num) max = num;
            if (min > num) min = num;
        }
        cout << 2 * (max - min) << '\n';
    }

    return 0;
}