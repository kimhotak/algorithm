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

    int n;
    cin >> n;
    vector<string> mirror(n);
    for (int i = 0; i < n; i++) {
        cin >> mirror[i];
    }

    int op;
    cin >> op;
    if (op == 2) {
        for (int i = 0; i < n; i++) {
            reverse(mirror[i].begin(), mirror[i].end());
        }
    }
    else if (op == 3) {
        reverse(mirror.begin(), mirror.end());
    }
    for (string s : mirror) cout << s << '\n';

    return 0;
}