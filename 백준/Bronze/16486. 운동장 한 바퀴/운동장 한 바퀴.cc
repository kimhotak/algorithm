#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    double d1, d2, pi = 3.141592;
    cin >> d1 >> d2;
    cout << fixed << setprecision(6);
    cout << 2 * (d1 + d2 * pi);

    return 0;
}