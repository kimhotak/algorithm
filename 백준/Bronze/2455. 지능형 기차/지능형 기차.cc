#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
// <bits/stdc++.h> gcc 전용
#include <vector>
#include <string>
#include <algorithm> // sort, max, min 등
#include <iomanip>   // setw, setfill 등
#include <climits>   // INT_MAX 등
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int train = 0, max = 0;
    for (int i = 0; i < 4; i++) {
        int out, in;
        cin >> out >> in;
		train = train - out + in;
        if (max < train) max = train;
    }
	cout << max << '\n';

    return 0;
}