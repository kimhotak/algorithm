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
        int tri[3];
        for (int i = 0; i < 3; i++) cin >> tri[i];
        sort(tri, tri + 3);

        cout << "Scenario #" << t << ":\n";
        if (tri[0] * tri[0] + tri[1] * tri[1] == tri[2] * tri[2]) cout << "yes\n";
        else cout << "no\n";
        cout << "\n";
    }

    return 0;
}
