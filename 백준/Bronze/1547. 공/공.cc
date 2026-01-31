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

    vector<int> arr(4);
    for (int i = 0; i <= 3; i++) {
        arr[i] = i;
    }

    int m;
    cin >> m;

    while (m--) {
        int a, b;
        cin >> a >> b;
        arr[0] = arr[a];
        arr[a] = arr[b];
        arr[b] = arr[0];
    }

    for (int i = 1; i <= 3; i++) {
        if (arr[i] == 1) cout << i;
    }


    return 0;
}
