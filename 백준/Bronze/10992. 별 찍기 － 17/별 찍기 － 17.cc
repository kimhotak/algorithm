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
    cin >> n;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < 2 * n - 1; j++) {
            if (j == n - 1 + i) {
                cout << '*';
                break;
            }
            else if (j == n - 1 - i) cout << '*';
            else cout << ' ';
        }
        cout << '\n';
    }
    for (int i = 0; i < 2 * n - 1; i++) cout << '*';


    return 0;
}