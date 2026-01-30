#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <algorithm>
#include <iomanip>
#include <climits>
#include <utility>
#include <cmath>
#include <sstream>
#include <queue>
#include <stack>
#include <deque>
using namespace std;

int gcd(int x, int y);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    while (n--) {
        int a, b;
        cin >> a >> b;
        cout << (long long) a * b / gcd(a,b) << '\n';
    }

    return 0;
}

int gcd(int x, int y) {
    int z;
    while (y != 0) {
        z = y;
        y = x % y;
        x = z;
    }
    return x;
}