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

    int n, m;
    cin >> n >> m;
    vector<int> arr(n + 1);
    while (m--) {
        int a, b;
        cin >> a >> b;
        arr[a]++;
        arr[b]++;
    }
    for (int i = 1; i <= n; i++) {
        cout << arr[i] << '\n';
    }

    return 0;
}
