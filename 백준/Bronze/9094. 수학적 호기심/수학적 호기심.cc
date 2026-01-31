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
        int n, m;
        cin >> n >> m;
        int cnt = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a+1; b < n; b++) { 
                if ((a * a + b * b + m) % (a * b) == 0) cnt++;
            }
        }
        cout << cnt << '\n';
    }


    return 0;
}
