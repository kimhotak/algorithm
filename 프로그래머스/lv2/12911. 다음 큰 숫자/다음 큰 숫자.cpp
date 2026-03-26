#include<bits/stdc++.h>

using namespace std;

int solution(int n) {
    int nc = bitset<32>(n).count();
    while (bitset<32>(++n).count() != nc) 1;
    
    return n;
}
