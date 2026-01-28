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
    
    map<int, int> m;
    int sum = 0, max = 0;
    for (int i = 0; i < 10; i++) {
        int tmp;
        cin >> tmp;
        sum += tmp;
        m[tmp]++;
        if (m[tmp] > m[max]) {
            max = tmp;
		}
    }

    cout << sum / 10 << '\n' << max;

    return 0;
}