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

    int a, b;
    cin >> a >> b;
    int sum = 0, cnt = 1;
    for (int i = 1; cnt <= b; i++) {
        for (int j = 0; j < i && cnt <= b; j++) {
            if (cnt >= a) sum += i;
            cnt++;
        }
    }
    cout << sum;


    return 0;
}
