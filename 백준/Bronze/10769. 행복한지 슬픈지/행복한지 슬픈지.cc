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

    string s;
    getline(cin, s);
    int happy = 0, sad = 0;
    if (s.length() >= 3) {
        for (int i = 0; i < s.length() - 3; i++) {
            if (s[i] == ':' && s[i + 1] == '-') {
                if (s[i + 2] == '(') sad++;
                else if (s[i + 2] == ')') happy++;
            }
        }
    }
    if (happy == 0 && sad == 0) cout << "none";
    else if (happy == sad) cout << "unsure";
    else if (happy > sad) cout << "happy";
    else cout << "sad";

    return 0;
}