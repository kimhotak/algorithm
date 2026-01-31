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

    string f;
    int n;
    cin >> f >> n;
    int cnt = 0;
    while (n--) {
        string s;
        cin >> s;
        bool instr = false;
        for (int i = 0; i < s.length(); i++) {
            bool flag = true;
            for (int j = 0; j < f.length(); j++) {
                if (f[j] != s[(i + j) % s.length()]) flag = false;
            }
            if (flag) {
                instr = true;
                break;
            }
        }
        if (instr) cnt++;
    }
    cout << cnt;

    return 0;
}
