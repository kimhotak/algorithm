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
    getline(cin, s);
    for (int i = 0; i < s.length(); i++) {
        if (!isalpha(s[i])) continue;
        bool isup = isupper(s[i]);
        s[i] = tolower(s[i]);
        s[i] = (s[i] - 'a' + 13) % 26 + 'a';
        if (isup) s[i] = toupper(s[i]);
    }
    cout << s;

    return 0;
}