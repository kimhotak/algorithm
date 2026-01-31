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

    char t;
    int cnt = 0;
    for (int r = 0; r < 8; r++) {
        for (int c = 0; c < 8; c++) {
            cin >> t;
            if (t == 'F' && !((r + c) & 1)) cnt++;
        }
    }
    cout << cnt;

    return 0;
}
