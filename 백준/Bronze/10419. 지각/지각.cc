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

    int t;
    cin >> t;
    while (t--) {
        int d;
        cin >> d;
        // d = t + t*t
        // d = t(t+1)
        int x = 1;
        while (x * (x + 1) <= d) x++;
        cout << x - 1 << '\n';
    }


    return 0;
}
