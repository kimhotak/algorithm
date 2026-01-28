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

    vector<int> arr(9);
    int sum = 0;
    for (int i = 0; i < 9; i++) {
        cin >> arr[i];
        sum += arr[i];
    }

    pair<int, int> not7;
    for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
            if (sum - arr[i] - arr[j] == 100) {
                not7.first = i;
                not7.second = j;
            }
        }
    }
    for (int i = 0; i < 9; i++) {
        if (i != not7.first && i != not7.second) {
            cout << arr[i] << '\n';
        }
    }


    return 0;
}