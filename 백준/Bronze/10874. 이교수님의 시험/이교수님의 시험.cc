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
    for (int i = 1; i <= n; i++) {
        bool flag = true;
        for (int j = 0; j < 10; j++) {
            int ans;
            cin >> ans;
            if (ans != (j % 5)+1) {
                flag = false;
            }
        }
        if (flag) cout << i << '\n';
    }

    return 0;
}
