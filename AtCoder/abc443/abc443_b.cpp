#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;
    int cnt = 0, i = 0;
    while (cnt + n + i < k) {
        cnt += n + i++;
    }
    cout << i;

    return 0;
}

