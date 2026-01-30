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

    while (1) {
        string str;
        getline(cin, str);
        if (str == "#") break;

        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isalpha(str[i])) check += (str[i] - 'A' + 1) * (i + 1);
        }
        cout << check << '\n';
    }
    
    return 0;
}
