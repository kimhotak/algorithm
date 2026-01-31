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
        int n, d;
        cin >> n >> d;
        int cnt = 0;
        while (n--) {
            int v, f, c;
            cin >> v >> f >> c;
            if (d <= ((double)f / c) * v) cnt++;
        }
        cout << cnt << '\n';
    }

    return 0;
}
