#include<bits/stdc++.h>

using namespace std;

int solution(int n) {
    int i2 = 0, i1 = 1;
    for (int i = 2; i<= n; i++) {
        int i0 = (i1 + i2)%1234567;
        i2 = i1;
        i1 = i0;
    }
    return i1;
}