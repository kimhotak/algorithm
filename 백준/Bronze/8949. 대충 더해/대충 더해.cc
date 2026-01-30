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

    int a, b;
    cin >> a >> b;
    string str;
    while (a != 0 || b != 0) {
        str = to_string(a % 10 + b % 10) + str;
        a /= 10;
        b /= 10;
    }
    cout << str;

    return 0;
}
