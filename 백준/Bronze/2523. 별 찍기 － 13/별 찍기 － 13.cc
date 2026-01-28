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

    int n, i = 0;
    cin >> n;
    while (i < n) {
        for (int j = 0; j <= i; j++) cout << '*';
		cout << '\n';
        i++;
    }

    while (i > 0) {
        i--;
        for (int j = 0; j < i; j++) cout << '*';
		cout << '\n';
	}

    return 0;
}