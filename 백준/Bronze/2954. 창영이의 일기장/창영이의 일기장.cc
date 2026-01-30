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

    string str, mo = "aeiou";
    getline(cin, str);
    for (int i = 0; i < str.length(); i++) {
        cout << str[i];
        if (mo.find(str[i]) != string::npos) i += 2;
    }

    return 0;
}
