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
        int n;
        cin >> n;

        string s = to_string(n);
        reverse(s.begin(), s.end());
        string sum = to_string(n + stoi(s));

        bool flag = true;
        int l = 0, r = sum.length() - 1;
        while (l <= r) {
            if (sum[l++] != sum[r--]) {
                flag = false;
                break;
            }
        }

        if (flag) cout << "YES\n";
        else cout << "NO\n";
    }

    return 0;
}