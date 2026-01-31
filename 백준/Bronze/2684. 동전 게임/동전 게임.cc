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

    int p;
    cin >> p;
    while (p--) {
        string s;
        cin >> s;
        int arr[8] = { 0 };
        for (int i = 0; i < s.size(); i++) s[i] = s[i] == 'H' ? '1' : '0';
        for (int i = 0; i < s.size() - 2; i++) {
            arr[bitset<3>(s.substr(i, 3)).to_ulong()]++;
        }
        for (int i : arr) cout << i << ' ';
        cout << '\n';
    }


    return 0;
}
