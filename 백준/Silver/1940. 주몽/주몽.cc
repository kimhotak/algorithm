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

    int n, m;
    cin >> n >> m;
    map<int,int> arr;
    set<int> s;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        arr[tmp]++;
        s.insert(tmp);
    }
    
    int cnt = 0;
    vector<int> v(s.begin(), s.end());
    int lo = 0, hi = s.size()-1;
    while (lo < hi) {
        int l = v[lo], h = v[hi];
        if (l + h == m) {
            cnt += arr[l] * arr[h];
            lo++;
            hi--;
        }
        else if (l + h < m) lo++;
        else hi--;
    }
    cout << cnt;

    return 0;
}
