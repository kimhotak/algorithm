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
        int n;
        cin >> n;
        cout << "Pairs for " << n << ':';
        for (int i = 1; i < (float)n / 2; i++) {
            if (i != 1) cout << ',';
            cout << ' ' << i << ' ' << n - i;
        }
        cout << '\n';
    }

    return 0;
}
