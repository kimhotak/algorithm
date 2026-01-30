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

    map<string, int> m;
    string table = "black brown red orange yellow green blue violet grey white";
    stringstream ss(table);
    string color;
    int i = 0;
    while (ss >> color) {
        m.insert({color, i++});
    }
    string a, b, c;
    cin >> a >> b >> c;

    cout << fixed << setprecision(0);
    cout << (int)(m.at(a) * 10 + m.at(b)) * pow(10, m.at(c)) << '\n';
    

    return 0;
}
