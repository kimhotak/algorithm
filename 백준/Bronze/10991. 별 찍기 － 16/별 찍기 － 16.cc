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
    
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = n; j > i; j--) cout << ' ';
        for (int j = 0; j < i; j++) cout << "* ";
        cout << '\n';
    }

    return 0;
}