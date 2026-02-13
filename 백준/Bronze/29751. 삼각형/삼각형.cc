#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int w, h;
    cin >> w >> h;
    cout << fixed << setprecision(1);
    cout << (double)w * h / 2;

    return 0;
}