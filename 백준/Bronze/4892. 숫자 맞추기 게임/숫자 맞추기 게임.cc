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

    int i = 1;
    while (1) {
        int n;
        cin >> n;
        if (n == 0) break;
        cout << i++ << ". " << ((n & 1) ? "odd " : "even ") << n / 2 << '\n';
    }

    return 0;
}
