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
    
    int n;
    cin >> n;
    int res = 0;
    for (int i = 0; i < n; i++) {
        int counter[7] = { 0 };
        for (int i = 0; i < 4; i++) {
            int tmp;
            cin >> tmp;
            counter[tmp]++;
        }

        int price = -1;
        for (int i = 1; i < 7; i++) {
            if (counter[i] == 4) {
                price = 50000 + i * 5000;
                break;
            }
        }
        if (price == -1) {
            for (int i = 1; i < 7; i++) {
                if (counter[i] == 3) {
                    price = 10000 + i * 1000;
                }
            }
        }
        if (price == -1) {
            pair<int, int> two = { -1,-1 };
            for (int i = 1; i <= 6; i++) {
                if (counter[i] == 2) {
                    if (two.first != -1) two.second = i;
                    else two.first = i;
                }
            }
            if (two.second != -1) price = 2000 + two.first * 500 + two.second * 500;
            else if (two.first != -1) price = 1000 + two.first * 100;
        }
        if (price == -1) {
            for (int i = 6; i > 0; i--) {
                if (counter[i] != 0) {
                    price = i * 100;
                    break;
                }
            }
        }
        res = max(res, price);
    }
    cout << res;

    return 0;
}
