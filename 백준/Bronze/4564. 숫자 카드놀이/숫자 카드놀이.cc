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

    while (1) {
        int s;
        cin >> s;
        if (s == 0) break;

        while (s > 9) {
            int ns = 1;
            for (char c : to_string(s)) {
                ns *= c - '0';
            }
            cout << s << ' ';
            s = ns;
        }
        cout << s << '\n';
    }


    return 0;
}
