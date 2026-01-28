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
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k;
    cin >> k;
    for (int i = 1; i <= k; i++) {
        cout << "Class " << i << '\n';
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) cin >> arr[i];
        sort(arr.begin(), arr.end());
        
        int max_gap = 0;
        for (int i = 1; i < n; i++) {
            if (max_gap < arr[i] - arr[i - 1]) max_gap = arr[i] - arr[i - 1];
        }
        cout << "Max " << arr[n - 1] << ", Min " << arr[0] << ", Largest gap " << max_gap << '\n';
    }

    return 0;
}