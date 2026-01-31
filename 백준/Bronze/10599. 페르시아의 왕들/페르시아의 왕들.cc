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

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (1) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        if (a == 0 && b == 0 && c == 0 && d == 0) break;
        cout << c - b << ' ' << d - a << '\n';
    }

    return 0;
}
