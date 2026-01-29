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

    int m, d;
    cin >> d >> m;
	int total_days = 0;
	int month_days[] = {0,  31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 , 31 };
	for (int i = 1; i < m; i++) {
		total_days += month_days[i];
	}
	total_days += d;

	string days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	int day_of_week = (total_days + 2) % 7;

	
	cout << days[day_of_week];

    return 0;
}