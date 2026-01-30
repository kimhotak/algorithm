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

    int num = 1;
    while(1) {
        string a, b;
        cin >> a >> b;
        if (a == "END" && a == b) break;

        int al[26] = { 0 };
        for (char c : a) al[c - 'a']++;
        for (char c : b) al[c - 'a']--;
        bool flag = true;
        for (int i : al) if (i != 0) flag = false;

        cout << "Case " << num++ << ": ";
        if (flag) cout << "same\n";
        else cout << "different\n";
    }

    return 0;
}
