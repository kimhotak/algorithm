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
    cin.ignore();
    for (int tc = 1; tc <= t; tc++) {
        cout << "Case " << tc << ": ";
        
        int show[26] = { 0 };
        string str;
        getline(cin, str);
        for (char c : str) if (isalpha(c)) show[tolower(c) - 'a']++;
        int m = *min_element(show, show + 26);
        if (m == 0) cout << "Not a pangram\n";
        else if (m == 1) cout << "Pangram!\n";
        else if (m == 2) cout << "Double pangram!!\n";
        else if (m == 3) cout << "Triple pangram!!!\n";
    }

    return 0;
}
