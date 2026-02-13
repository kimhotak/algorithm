#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    double d, h, w;
    cin >> d >> h >> w;
    // d * d = h*x * h*x + w*x + w*x
    // d * d = (h * h + w * w) x * x;
    double x = sqrt((d * d) / (h * h + w * w));
    cout << (int)(h * x) << ' ' << (int)(w * x);

    return 0;
}