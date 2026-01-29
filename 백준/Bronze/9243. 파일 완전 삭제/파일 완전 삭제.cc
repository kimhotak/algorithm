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

    int n;
    string befor, after;
    cin >> n >> befor >> after;
    if (n & 1) {
        for (int i = 0; i < befor.length(); i++) {
            befor[i] = (befor[i] - '0') ^ 1 + '0';
        }
    }

    if (after == befor) cout << "Deletion succeeded";
    else cout << "Deletion failed";

    return 0;
}