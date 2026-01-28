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
    
    for (int i = 0; i < 3; i++) {
        int cnt = -1;
        for (int j = 0; j < 4; j++) {
            int tmp;
            cin >> tmp;
            if (tmp == 0) cnt++;
        }
        if (cnt == -1) cnt = 4;
        cout << (char)('A' + cnt) << '\n';
    }

    return 0;
}