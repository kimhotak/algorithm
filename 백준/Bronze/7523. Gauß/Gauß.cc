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

    int tc;
    cin >> tc;
    for (int t = 1; t <= tc; t++) {
        cout << "Scenario #" << t << ":\n";
        long long n, m;
        cin >> n >> m;
        cout << (m - n + 1) * (n + m) / 2;
        
        cout << "\n\n";
    }

    return 0;
}
