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

    int res, num;
    char op;
    cin >> res;
    while (cin >> op >> num) {
        if (op == '+') res += num;
        else if (op == '-') res -= num;
        else if (op == '*') res *= num;
        else if (op == '/') res /= num;
    }
    cout << res;

    return 0;
}
