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

    long long f[70];
    f[0] = f[1] = 1;
    f[2] = 2;
    f[3] = 4;

    for (int i = 4; i < 70; i++) f[i] = f[i - 1] + f[i - 2] + f[i - 3] + f[i - 4];

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << f[n] << '\n';
    }
    
    return 0;
}
