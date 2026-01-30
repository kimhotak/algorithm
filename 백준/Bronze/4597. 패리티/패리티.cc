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
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (1) {
        string str;
        cin >> str;
        if (str == "#") break;
        bool cntisodd = false;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str[i] == '1') cntisodd ^= true;
            cout << str[i];
        }
        bool parityisodd = str[str.length() - 1] == 'o';
        if (cntisodd ^ parityisodd) cout << 1;
        else cout << 0;
        cout << '\n';
    }

    return 0;
}