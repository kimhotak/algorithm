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
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) cout << ' ';
        cout << '*';
        if (i != 0) {
            for (int j = 0; j < (2 * i-1); j++) cout << ' ';
            cout << '*';
        }
        cout << '\n';
    }

    return 0;
}
