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
    
    int n, sum = 0, score = 1;
    cin >> n;
    for (int i = 0; i < n; i++) {
        bool correct;
		cin >> correct;
        if (correct) {
            sum += score;
            score++;
        } else {
            score = 1;
		}
    }
	cout << sum << "\n";

    return 0;
}