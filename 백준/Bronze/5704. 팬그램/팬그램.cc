#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <map>
#include <set>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
#include <utility> // pair가 들어있는 헤더
#include <math.h>
#include <numeric> // gcd, lcm이 들어있는 헤더#include <string>
#include <sstream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (1) {
        string str;
        getline(cin, str);
        if (str == "*") break;
        bool alpha[26] = { false };
        for (int i = 0; i < str.length(); i++) {
            if (str[i] != ' ') alpha[str[i] - 'a'] = true;
        }
        
        bool flag = true;
        for (bool b : alpha) if (!b)flag = false;
        if (flag) cout << "Y\n";
        else cout << "N\n";
    }

    return 0;
}
