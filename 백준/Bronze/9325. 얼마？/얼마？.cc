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

    int t;
    cin >> t;
    while (t--) {
        int s, n, q, p;
        cin >> s >> n;
        for (int i = 0; i < n; i++) {
            cin >> q >> p;
			s += q * p;
        }
        cout << s << '\n';
    }

    return 0;
}