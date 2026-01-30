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
#include <numeric>
#include <sstream>
#include <queue>
#include <stack>
#include <deque>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    double cur, bfr = -1;
    cout << fixed << setprecision(2);
    while (1) {
        cin >> cur;
        if (cur == 999) break;
        if (bfr != -1) {
            cout << cur - bfr << '\n';
        }
        bfr = cur;
    }

    return 0;
}
