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
#include <numeric> // gcd, lcm이 들어있는 헤더
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int p1w = 0, p2w = 0;
        while (n--) {
            char p1, p2;
            cin >> p1 >> p2;
            if (p1 == p2) continue;
            if ((p1 == 'R' && p2 == 'P') ||
                (p1 == 'P' && p2 == 'S') ||
                (p1 == 'S' && p2 == 'R')) p2w++;
            else p1w++;
        }
        if (p1w == p2w) cout << "TIE\n";
        else if (p1w > p2w) cout << "Player 1\n";
        else cout << "Player 2\n";
    }
    

    return 0;
}
