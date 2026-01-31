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

    int a, b, c, d, e;
    cin >> a >> b >> c >> d >> e;
    int x = a * e;
    int y = b;
    if (e > c) y += d * (e - c);
    cout << min(x, y);

    return 0;
}
