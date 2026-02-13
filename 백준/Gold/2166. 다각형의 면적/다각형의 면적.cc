#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<pair<ll, ll>> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i].first >> arr[i].second;
    }

    ll w = 0;
    for (int i = 0; i < n; i++) {
        w += arr[i].first * arr[(i + 1) % n].second;
        w -= arr[i].second * arr[(i + 1) % n].first;
    }

    cout << fixed << setprecision(1);
    cout << (double)(abs(w)) / 2;

    return 0;
}