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

    int t;
    cin >> t;
    while (t--) {
        string f;
        cin >> f;
        cout << "Do-it";
        if (f[f.length() / 2] != f[f.length() / 2 - 1]) cout << "-Not";
        cout << "\n";
    }

    return 0;
}
