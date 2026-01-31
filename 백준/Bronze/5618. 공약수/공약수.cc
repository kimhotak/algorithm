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
#include <bitset>
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

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int a, b, c;
    cin >> a >> b;
    int g = gcd(a, b);

    if (n == 3) {
        cin >> c;
        g = gcd(g, c);
    }

    for (int i = 1; i <= g; i++) {
        if (g % i == 0) cout << i << '\n';
    }



    return 0;
}
