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

    string a, b;
    cin >> a >> b;
    replace(a.begin(), a.end(), '6', '5');
    replace(b.begin(), b.end(), '6', '5');
    cout << stoi(a) + stoi(b) << ' ';
    replace(a.begin(), a.end(), '5', '6');
    replace(b.begin(), b.end(), '5', '6');
    cout << stoi(a) + stoi(b);

    return 0;
}
