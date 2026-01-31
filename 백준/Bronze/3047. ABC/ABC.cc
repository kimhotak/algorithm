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

    vector<int> arr(3);
    for (int i = 0; i < 3; i++) cin >> arr[i];
    sort(arr.begin(), arr.end());
    string str;
    cin >> str;
    for (char c : str) cout << arr[c - 'A'] << ' ';

    return 0;
}
