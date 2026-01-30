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

    int n, w, h;
    cin >> n >> w >> h;
    double x = sqrt(w * w + h * h);
    while (n--) {
        int y;
        cin >> y;
        if (y > x) cout << "NE\n";
        else cout << "DA\n";
    }

    return 0;
}
