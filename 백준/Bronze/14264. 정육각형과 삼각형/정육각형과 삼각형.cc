#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    const double PI = acos(-1);
    double l;
    cin >> l;
    cout << fixed << setprecision(10);
    cout << l * l * sin(120 * PI / 180) / 2;

    return 0;
}