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

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        string str;
        getline(cin, str);
        stringstream ss(str);
        string s;
        while (ss >> s) {
            for (int i = s.length() - 1; i >= 0; i--) cout << s[i];
            cout << ' ';
        }
        cout << '\n';
    }


    return 0;
}
