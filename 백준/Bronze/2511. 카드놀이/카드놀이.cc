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

    int aw = 0, bw = 0;
    char lastwin = ' ';
    int arr[10] = { 0 };
    for (int i = 0; i < 10; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < 10; i++) {
        int t;
        cin >> t;
        arr[i] -= t;
    }

    for (int i = 0; i < 10; i++) {
        if (arr[i] > 0) {
            aw+=3;
            lastwin = 'A';
        }
        else if (arr[i] < 0) {
            bw+=3;
            lastwin = 'B';
        }
        else {
            aw++;
            bw++;
        }
    }

    cout << aw << ' ' << bw << '\n';
    if (aw == 10 && bw == 10) cout << 'D';
    else if (aw > bw) cout << 'A';
    else if (bw > aw) cout << 'B';
    else cout << lastwin;

    return 0;
}