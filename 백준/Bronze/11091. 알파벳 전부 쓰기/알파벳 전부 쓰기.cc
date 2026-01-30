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


    int n;
    cin >> n;
    cin.ignore();
    while (n--) {
        string str;
        getline(cin, str);
        if (str == "*") break;
        bool alpha[26] = { false };
        for (int i = 0; i < str.length(); i++) {
            if (isalpha(str[i])) {
                alpha[tolower(str[i]) - 'a'] = true;
            }
        }

        bool ispan = true;
        for (bool b : alpha) if (!b)ispan = false;

        if (ispan) cout << "pangram\n";
        else {
            cout << "missing ";
            for (int i = 0; i < 26; i++) {
                if (!alpha[i]) cout << (char)('a' + i);
            }
            cout << '\n';
        }

    }

    return 0;
}
