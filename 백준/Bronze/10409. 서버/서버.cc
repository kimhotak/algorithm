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

    int n, t;
    cin >> n >> t;
    int cnt = 0, task;
    while (cin >> task) {
        if (t - task < 0) break;
        t -= task;
        cnt++;
    }
    cout << cnt;

    return 0;
}
