#include<bits/stdc++.h>

using namespace std;

int solution(string A, string B) {
    A += A;
    for (int i = 0; i < B.size(); i++) {
        if (A.substr(B.size()-i,B.size()) == B) return i;
    }
    return -1;
}