#include<bits/stdc++.h>
using namespace std;

int gcd(int x, int y) {
    int z;
    while (y != 0) {
        z = y;
        y = x % y;
        x = z;
    }
    return x;
}

int solution(int a, int b) {
    int ab = gcd(a,b);
    b /= ab;
    while (b % 2 == 0) b /= 2;
    while (b % 5 == 0) b /= 5;
    return b == 1 ? 1 : 2;
}