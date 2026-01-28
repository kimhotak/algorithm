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

    vector<pair<int,int> > arr(8);
    for (int i = 0; i < 8; i++) {
        cin >> arr[i].first;
        arr[i].second = i+1;
    }

    sort(arr.begin(), arr.end());
    int sum = 0;
    for (int i = 3; i < 8; i++) {
        sum += arr[i].first;
    }
    cout << sum << '\n';

    vector<int> res(5);
    for (int i = 3; i < 8; i++) {
        res[i-3] =  arr[i].second;
    }

    sort(res.begin(), res.end());
    for (int i : res) cout << i << ' ';

    return 0;
}