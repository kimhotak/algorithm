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
#include <math.h>
#include <numeric> // gcd, lcm이 들어있는 헤더
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int num = 1;
    while (true) {
        int a, b;
        string op;
        cin >> a >> op >> b;
        if (op == "E") break;
        bool flag = false;
        if (op[0] == '>' && a > b) flag = true;
        if (op[0] == '<' && a < b) flag = true;
        if (op[1] == '=' && a == b && op[0] != '!') flag = true;
        if (op[0] == '!' && a != b) flag = true;
        cout << "Case " << num++ << ": " << (flag ? "true" : "false") << '\n';
    }

    return 0;
}
