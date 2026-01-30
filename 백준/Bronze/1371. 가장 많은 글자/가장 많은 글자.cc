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

    string str;
    int a[26] = { 0 };
    while (cin >> str) {
        for (char c : str) {
            if (isalpha(c)) a[c - 'a']++;
        }
    }
    int m = *max_element(a, a + 26);
    for (int i = 0; i < 26; i++) if (a[i] == m) cout << (char)('a' + i);


    return 0;
}
