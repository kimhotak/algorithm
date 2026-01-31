#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    //freopen("input.txt", "r", stdin);

    int n, t;
    cin >> n >> t;
    int wt = 0, ws = 0;
    while (n--) {
        int aoki;
        cin >> aoki;
        if (ws < aoki) {
            wt += aoki - ws;
            ws = aoki + 100;
        }
    }
    if (t > ws) wt += t - ws;
    cout << wt;

    return 0;
}

