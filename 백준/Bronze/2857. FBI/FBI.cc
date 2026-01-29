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

    bool isfind = false;
    for (int i = 1; i <= 5; i++) {
        string name;
        cin >> name;

        if (name.find("FBI") != string::npos) {
            cout << i << ' ';
            isfind = true;
        }
    }
    
    if (!isfind) cout << "HE GOT AWAY!";

    return 0;
}