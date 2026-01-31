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

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<pair<int,int>> arr(n+1);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            cin >> arr[i].first;
            arr[i].second = i;
            sum += arr[i].first;
        }
        sort(arr.begin(), arr.end());
        if (arr[n].first == arr[n - 1].first) cout << "no winner\n";
        else if (arr[n].first * 2 > sum) cout << "majority winner " << arr[n].second << '\n';
        else cout << "minority winner " << arr[n].second << '\n';
    }

    return 0;
}
