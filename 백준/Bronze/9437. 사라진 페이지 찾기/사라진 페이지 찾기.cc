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

    int n, p;
    while (cin >> n >> p) {
        int paper = p;
        if (p > n / 2) paper = n - p + 1;
        if (!(paper & 1)) paper--;

        int arr[] = { paper, paper + 1, n - paper, n - paper + 1 };
        for (int i = 0; i < 4; i++) if (arr[i] != p) cout << arr[i] << ' ';
        cout << '\n';
    }

    return 0;
}
