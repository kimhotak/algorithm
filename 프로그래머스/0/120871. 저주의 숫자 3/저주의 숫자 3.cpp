#include<bits/stdc++.h>
using namespace std;

int solution(int n) {
    int x3 = 0;
    for (int i = 1; i <= n; i++) {
        x3++;
        while (x3 % 3 == 0 || to_string(x3).find("3") != string::npos) x3++;
    }
    return x3;
}