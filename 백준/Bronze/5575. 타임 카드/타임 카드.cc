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

    for (int t = 0; t < 3; t++) {
        int sh, sm, ss, eh, em, es;
        cin >> sh >> sm >> ss >> eh >> em >> es;

        int st = (sh * 3600) + (sm * 60) + ss;
        int et = (eh * 3600) + (em * 60) + es;

        int wt = et - st;

        cout << wt / 3600 << " " << (wt % 3600) / 60 << " " << wt % 60 << '\n';
    }
    return 0;
}
