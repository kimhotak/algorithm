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
    
    int odd = INT32_MAX, odd_sum = 0;
    for (int i = 0; i < 7; i++) {
        int num;
        cin >> num;
        if (num &1) {
            if (num < odd) odd = num;
			odd_sum += num;
        }
    }
    if (odd_sum == 0) cout << -1 << '\n';
	else cout << odd_sum << '\n' << odd << '\n';

    return 0;
}