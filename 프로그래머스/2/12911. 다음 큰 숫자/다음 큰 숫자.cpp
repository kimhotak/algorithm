#include<bits/stdc++.h>

using namespace std;
int bitcount(int x) {
    int cnt = 0;
    while (x > 0) {
        cnt += x&1;
        x >>= 1;
    }
    return cnt;
};

int solution(int n) {
    int answer = 0;
    int nc = bitcount(n);
    while (bitcount(++n) != nc) 1;
    
    return n;
}
