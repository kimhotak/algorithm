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
    while (n--) {
        string s;
        cin >> s;
        if (isalpha(s[0])) {
            cout << "skipped\n";
            continue;
        }
        stringstream ss(s);
        int a, b;
        char c;
        ss >> a >> c >> b;
        cout << a + b << '\n';
    }

    return 0;
}
