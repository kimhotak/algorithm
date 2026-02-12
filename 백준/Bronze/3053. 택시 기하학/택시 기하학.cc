#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    double r;
    cin >> r;
    double pi = acos(-1);
    cout << fixed << setprecision(6);
    cout << r * r * pi << '\n';
    cout << pow(sqrt(2 * r * r), 2);

    return 0;
}