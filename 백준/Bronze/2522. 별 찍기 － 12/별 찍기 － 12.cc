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

    int n, i = 1;
    cin >> n;
    while (i++ <= n) {
		for (int j = 0; j < n - i + 1; j++) cout << ' ';
		for (int j = 0; j < i - 1; j++) cout << '*';
		cout << '\n';
    }
    i--;
	while (--i > 1) {
		for (int j = 0; j < n - i + 1; j++) cout << ' ';
		for (int j = 0; j < i - 1; j++) cout << '*';
		cout << '\n';
    }

    return 0;
}