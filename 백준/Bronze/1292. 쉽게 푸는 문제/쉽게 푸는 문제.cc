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

    int a, b;
    cin >> a >> b;

    int sum = 0;
    int i = 0, num = 1;
    while (i < b) {
        for (int j = 0; j < num && i < b; j++) {
            if (i >= a-1) sum += num;
            i++;
        }
        num++;
    }

    cout << sum;

    return 0;
}