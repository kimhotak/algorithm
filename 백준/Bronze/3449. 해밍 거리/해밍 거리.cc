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
        string a, b;
        cin >> a >> b;
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a[i] != b[i]) cnt++;
        }

        cout << "Hamming distance is " << cnt << ".\n";
    }

    return 0;
}
