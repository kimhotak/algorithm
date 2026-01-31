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

    string s;
    cin >> s;
  
    int first = s[0] - '0';
    string first_bin = bitset<3>(first).to_string();

    if (first >= 4) cout << first_bin;
    else if (first >= 2) cout << first_bin.substr(1);
    else cout << first_bin.substr(2);

    for (int i = 1; i < s.length(); i++) {
        int n = s[i] - '0';
        cout << bitset<3>(n);
    }

    return 0;
}
