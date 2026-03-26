#include<bits/stdc++.h>
using namespace std;

int solution(int a, int b) {
    int ab = gcd(a,b);
    b /= ab;
    while (b % 2 == 0) b /= 2;
    while (b % 5 == 0) b /= 5;
    return b == 1 ? 1 : 2;
}