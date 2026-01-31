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

    int n;
    cin >> n;
    cin.ignore();
    while (n--) {
        string str;
        getline(cin, str);
        pair<string, string> fs;
        stringstream ss(str);
        ss >> fs.first;
        ss >> fs.second;
        string s;
        while (ss >> s) cout << s << ' ';
        cout << fs.first << ' ' << fs.second << '\n';
    }

    return 0;
}
