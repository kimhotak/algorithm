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

    int m[] = { 500, 100, 50, 10, 5, 1 };
    int n, coin = 0;
    cin >> n;
    n = 1000 - n;
    for (int i = 0; i < 6; i++) {
        coin += n / m[i];
        n %= m[i];
    }
    cout << coin;

    return 0;
}
