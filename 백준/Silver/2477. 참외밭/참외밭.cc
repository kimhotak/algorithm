#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k;
    cin >> k;

    int arr[7][2]; // r, c
    arr[0][0] = 0;
    arr[0][1] = 0;

    for (int i = 1; i <= 6; i++) {
        int dir, len;
        cin >> dir >> len;
        if (dir > 2) {
            arr[i][0] = arr[i - 1][0] + (dir == 3 ? -1 : 1) * len;
            arr[i][1] = arr[i - 1][1];
        }
        else {
            arr[i][1] = arr[i - 1][1] + (dir == 2 ? -1 : 1) * len;
            arr[i][0] = arr[i - 1][0];
        }
    }

    int w = 0;
    for (int i = 0; i < 6; i++) {
        w += arr[i][0] * arr[i + 1][1];
        w -= arr[i][1] * arr[i + 1][0];
    }

    cout << k * abs(w >> 1);

    return 0;
}