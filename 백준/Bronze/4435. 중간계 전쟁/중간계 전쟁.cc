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
    int gscore[] = { 1,2,3,3,4,10 }, sscore[] = { 1,2,2,2,3,5,10 };
    for (int tc = 1; tc <= t; tc++) {
        int gv = 0, sv = 0;
        int num;
        for (int i = 0; i < 6; i++) {
            cin >> num;
            gv += gscore[i] * num;
        }

        for (int i = 0; i < 7; i++) {
            cin >> num;
            sv += sscore[i] * num;
        }
        
        cout << "Battle " << tc << ": ";
        if (gv == sv) cout << "No victor on this battle field\n";
        else if (gv > sv) cout << "Good triumphs over Evil\n";
        else cout << "Evil eradicates all trace of Good\n";
    }


    return 0;
}
