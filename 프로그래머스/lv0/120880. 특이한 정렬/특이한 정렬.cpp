#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> numlist, int n) {
    vector<int> answer;
    
    sort(numlist.begin(), numlist.end(), [&](int a, int b) {
        int na = abs(n - a), nb = abs(n - b);
        if (na != nb) return na < nb;
        return a > b;
    });
    
    return numlist;
}