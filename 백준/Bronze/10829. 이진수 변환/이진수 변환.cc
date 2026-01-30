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

    long long n;
    cin >> n;
    string s;
    while (n != 0) {
        s += to_string(n & 1);
        n = n >> 1;
    }
    for (int i = s.length() - 1; i >= 0; i--) cout << s[i];

    return 0;
}