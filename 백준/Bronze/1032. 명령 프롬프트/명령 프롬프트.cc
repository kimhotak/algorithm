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
#include <math.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<string> str(n);
    for (int i = 0; i < n; i++) {
        cin >> str[i];
    }

    for (int i = 0; i < str[0].length(); i++) {
        bool flag = true;
        for (int j = 1; j < n; j++) {
            if (str[j][i] != str[j-1][i]) {
                flag = false;
                break;
            }
        }
        cout << (flag ? str[0][i] : '?');
    }

    return 0;
}