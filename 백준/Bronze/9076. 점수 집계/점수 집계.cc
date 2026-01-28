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

    int t;
    cin >> t;
    while (t--) {
        vector<int> arr(5);
        for (int i = 0; i < 5; i++) cin >> arr[i];
        sort(arr.begin(), arr.end());
        if (arr[3] - arr[1] >= 4) cout << "KIN\n";
        else {
            int score = 0;
            for (int i = 1; i < 4; i++) score += arr[i];
            cout << score << '\n';
        }
    }

    return 0;
}