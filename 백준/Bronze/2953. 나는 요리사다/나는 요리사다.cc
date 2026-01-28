#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <map>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    vector<int> arr(5);
    int win = 0;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
            int tmp;
            cin >> tmp;
            arr[i] += tmp;
        }
        if (arr[i] > arr[win]) win = i;
    }

    cout << win + 1 << ' ' << arr[win];
    

    return 0;
}