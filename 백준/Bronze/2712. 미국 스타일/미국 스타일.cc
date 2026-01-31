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
    cout << fixed << setprecision(4);
    while (t--) {
        double v;
        string st;
        cin >> v >> st;
        if (st == "kg") {
            v *= 2.2046;
            st = "lb";
        }
        else if (st == "lb") {
            v *= 0.4536;
            st = "kg";
        }
        else if (st == "l") {
            v *= 0.2642;
            st = "g";
        }
        else if (st == "g") {
            v *= 3.7854;
            st = "l";
        }
        cout << v << ' ' << st << '\n';
    }

    return 0;
}
