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

    string s;
    cin >> s;
    vector<string> arr(s.length());
    for (int i = 0; i < s.length(); i++) {
        arr[i] = s.substr(i, s.length());
    }

    sort(arr.begin(), arr.end());
    for (string str : arr) cout << str << '\n';


    return 0;
}