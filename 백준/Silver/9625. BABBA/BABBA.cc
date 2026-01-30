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

    int k;
    cin >> k;
    vector<pair<int, int>> dp(k+1);
    dp[0] = { 1,0 };
    for (int i = 1; i <= k; i++) {
        dp[i] = { dp[i - 1].second, dp[i - 1].first + dp[i - 1].second };
    }

    cout << dp[k].first << ' ' << dp[k].second;

    return 0;
}
